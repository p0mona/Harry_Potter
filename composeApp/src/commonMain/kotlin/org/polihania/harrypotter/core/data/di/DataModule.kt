package org.polihania.harrypotter.core.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.polihania.harrypotter.core.data.HttpClientProvider
import org.polihania.harrypotter.core.data.HttpClientProviderImpl

val dataModule = module {
    singleOf(::HttpClientProviderImpl).bind<HttpClientProvider>()
}
