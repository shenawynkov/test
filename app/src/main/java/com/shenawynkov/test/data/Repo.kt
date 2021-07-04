package com.shenawynkov.test.data


import ae.digitalwise.jadeer.networking.models.safeCall.ResultWrapper
import ae.digitalwise.jadeer.networking.models.safeCall.safeApiCall
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.shenawynkov.test.networking.ApiService
import com.shenawynkov.test.networking.model.LineResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


open class Repo(
    val apiClient: ApiService,
    val context: Context
) {


    val key= "2ac08b517b49bac81aca1b9767446685"
    val appID="b4a8ec5c"
    public suspend fun getLines(

        lines: MutableLiveData<ArrayList<LineResponse>>,
        text: String,


        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        val map = HashMap<String, String>()
        val response = safeApiCall(dispatcher) {
            apiClient.get_nutrition(
                appID, key, text

            )
        }
        if (response is ResultWrapper.Success) {
            Log.d("ApiResponse", "success")
           val line= response.value
           val data= text.split(" ")
          line.quantity=  data.get(0)
          line.unit=  data.get(1)
          line.food=  data.get(2)
            lines.value?.add(line)




        }
    }

}