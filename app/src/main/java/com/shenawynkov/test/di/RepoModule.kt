
package com.shenawynkov.test.di


import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.shenawynkov.test.data.Repo
import com.shenawynkov.test.networking.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepoModule(val context: Context) {

    @Provides //scope is not necessary for parameters stored within the module
    fun context(): Context {
        return context
    }


    @Singleton
    @Provides
    fun provideHomeRepo(apiClient: ApiService, context: Context): Repo {
        return Repo(apiClient, context)
    }


}