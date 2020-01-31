package com.diegoferreiracaetano.domain.di

import com.diegoferreiracaetano.domain.user.UserInteractor
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

val domainModule: Module = module {
    single { UserInteractor(get(named("local")), get(named("payment"))) }
}
