package com.maishameds.post.di

import com.maishameds.post.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RemoteModule::class])

interface AppComponent {
    fun inject(mainActivity: MainActivity)
}