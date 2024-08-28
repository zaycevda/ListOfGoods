package com.example.listofgoods.di

import com.example.listofgoods.data.repository.GoodsRepositoryImpl
import com.example.listofgoods.domain.repository.GoodsRepository
import com.example.listofgoods.domain.usecase.DeleteGoodsUseCase
import com.example.listofgoods.domain.usecase.EditGoodsUseCase
import com.example.listofgoods.domain.usecase.GetGoodsListUseCase
import org.koin.dsl.module

val domainModule = module {
    single<GoodsRepository> { _ ->
        GoodsRepositoryImpl(goodsDao = get())
    }

    single { _ ->
        GetGoodsListUseCase(repository = get())
    }
    single { _ ->
        DeleteGoodsUseCase(repository = get())
    }
    single { _ ->
        EditGoodsUseCase(repository = get())
    }
}