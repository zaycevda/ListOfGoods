package com.example.listofgoods.di

import androidx.room.Room
import com.example.listofgoods.data.db.GoodsDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single { _ ->
        Room.databaseBuilder(
            context = androidContext(),
            klass = GoodsDatabase::class.java,
            name = "goods_database"
        )
        .createFromAsset(databaseFilePath = "data.db")
        .build()
    }

    single { _ ->
        get<GoodsDatabase>().goodsDao()
    }
}