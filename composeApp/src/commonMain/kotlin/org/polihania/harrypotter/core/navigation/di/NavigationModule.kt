package org.polihania.harrypotter.core.navigation.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.polihania.harrypotter.core.navigation.Navigation
import org.polihania.harrypotter.core.navigation.NavigationImpl

val navigationModule = module {

    singleOf(::NavigationImpl).bind<Navigation>()
}