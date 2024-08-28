package com.example.listofgoods

import android.app.Application
import com.example.listofgoods.di.appModule
import com.example.listofgoods.di.dataModule
import com.example.listofgoods.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GoodsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(androidContext = this@GoodsApp)
            modules(
                appModule,
                dataModule,
                domainModule
            )
        }
    }
}