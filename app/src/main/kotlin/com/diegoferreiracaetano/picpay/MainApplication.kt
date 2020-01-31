package com.diegoferreiracaetano.picpay

import android.app.Application
import com.diegoferreiracaetano.data.di.dataModule
import com.diegoferreiracaetano.domain.di.domainModule
import com.diegoferreiracaetano.router.di.routerModule
import com.diegoferreiracaetano.users.di.usersModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            loadKoinModules(listOf(
                usersModule,
                domainModule,
                dataModule,
                routerModule
            ))
        }
    }
}
