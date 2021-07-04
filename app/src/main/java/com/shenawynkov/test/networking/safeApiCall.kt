package ae.digitalwise.jadeer.networking.models.safeCall

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.gson.Gson
import com.shenawynkov.test.networking.model.ErrorResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.nio.charset.StandardCharsets

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T
): ResultWrapper<T> {
    return withContext(dispatcher) {
        try {
            ResultWrapper.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            Log.d("apiThrow", throwable.localizedMessage)

            when (throwable) {
                is IOException -> ResultWrapper.NetworkError
                is HttpException -> {
                    val code = throwable.code()
                    val errorResponse = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                        convertErrorBody(throwable)
                    } else {
                        TODO("VERSION.SDK_INT < KITKAT")
                    }
                    ResultWrapper.GenericError(code, errorResponse)
                }
                else -> {
                    ResultWrapper.GenericError(null, null)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.KITKAT)
private fun convertErrorBody(throwable: HttpException): ErrorResponse? {
    return try {
        throwable.response()?.errorBody()?.source()?.let {
            val moshiAdapter = Gson().fromJson<ErrorResponse>(
                it.readString(StandardCharsets.UTF_8),
                ErrorResponse::class.java
            )
            moshiAdapter
        }
    } catch (exception: Exception) {
        null
    }
}