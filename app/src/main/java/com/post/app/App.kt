package com.maishameds.post.app

import android.app.Application
import com.maishameds.post.di.AppComponent
import com.maishameds.post.di.DaggerAppComponent
import com.maishameds.post.di.RemoteModule

class App : Application() {

    val appComponent by lazy {
        initialiseAppComponent()
    }

    private fun initialiseAppComponent(): AppComponent {
        val builder = DaggerAppComponent.builder()
        return builder.remoteModule(RemoteModule(this)).build()
    }
}