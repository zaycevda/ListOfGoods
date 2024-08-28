package com.example.listofgoods.di

import com.example.listofgoods.ui.viewmodel.GoodsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<GoodsViewModel> { _ ->
        GoodsViewModel(
            getGoodsListUseCase = get(),
            deleteGoodsUseCase = get(),
            editGoodsUseCase = get()
        )
    }
}