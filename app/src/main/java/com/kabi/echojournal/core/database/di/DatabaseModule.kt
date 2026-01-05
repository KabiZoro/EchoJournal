package com.kabi.echojournal.core.database.di

import androidx.room.Room
import com.kabi.echojournal.core.database.EchoDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single<EchoDatabase> {
        Room.databaseBuilder(
            androidApplication(),
            EchoDatabase::class.java,
            "echo_db"
        ).build()
    }
    single {
        get<EchoDatabase>().echoDao
    }
}