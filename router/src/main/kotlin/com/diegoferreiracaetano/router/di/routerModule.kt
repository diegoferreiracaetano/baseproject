package com.diegoferreiracaetano.router.di

import com.diegoferreiracaetano.router.Router
import com.diegoferreiracaetano.router.user.UserRouter
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

val routerModule: Module = module {

    single<Router>(named("user")) { UserRouter() }
}
