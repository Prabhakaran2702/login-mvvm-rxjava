package com.example.seerloginmodule.core

import android.app.Application
import android.content.Context
import com.example.seerloginmodule.core.di.dataSourceModule
import com.example.seerloginmodule.core.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {



    override fun onCreate() {
        super.onCreate()
//        startKoin {
//            androidContext(this@App)
//            modules(dataSourceModule)
//            modules(repositoryModule)
//            modules(viewModelModule)
//            modules(networkModule)
//        }
    }

}