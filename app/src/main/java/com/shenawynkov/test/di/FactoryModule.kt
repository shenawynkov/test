package com.shenawynkov.test.di


import android.content.Context
import com.shenawynkov.test.data.Repo
import com.shenawynkov.test.ui.HomeViewModelFactory
import com.shenawynkov.test.ui.ListViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class FactoryModule {

    @Provides
    @Singleton
    fun homeFactory(

            repo: Repo
    ): HomeViewModelFactory {
        return HomeViewModelFactory(

                repo
        )
    }
    @Provides
    @Singleton
    fun listFactory(

            repo: Repo
    ): ListViewModelFactory {
        return ListViewModelFactory(

                repo
        )
    }

}