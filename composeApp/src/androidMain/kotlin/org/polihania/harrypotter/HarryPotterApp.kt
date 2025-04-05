package org.polihania.harrypotter

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.polihania.harrypotter.core.di.koinConfiguration


class HarryPotterApp : Application() {
    override fun onCreate() {
        super.onCreate()
        koinConfiguration {
            androidContext(this@HarryPotterApp)
        }
    }
}