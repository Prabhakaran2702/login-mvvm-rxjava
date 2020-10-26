package com.example.seerloginmodule.core.di


import org.koin.dsl.module

val dataSourceModule = module {
   // single<RemoteDataSource> { RemoteDataSourceImpl(service = get()) }
}