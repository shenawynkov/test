package com.shenawynkov.test

import android.app.Application

import com.shenawynkov.test.di.ApplicationComponent
import com.shenawynkov.test.di.DaggerApplicationComponent
import com.shenawynkov.test.di.RepoModule

class BaseApp : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder().repoModule(RepoModule(this)).build()
        appComponent.inject(this)
        //   LocaleChanger.initialize(getApplicationContext(), listOf(Locale("ar"), Locale("en")));

        // changeFont("en")

    }
}