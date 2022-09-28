package com.podolian.vamatestapp.app

import android.app.Application
import com.podolian.database.di.databaseModule
import com.podolian.vamatestapp.di.appModule
import com.podolian.vamatestapp.di.dataModule
import com.podolian.vamatestapp.di.domainModule
import com.podolian.network.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class VamaApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@VamaApp)
            modules(listOf(appModule, domainModule, dataModule, networkModule, databaseModule))
        }
    }
}