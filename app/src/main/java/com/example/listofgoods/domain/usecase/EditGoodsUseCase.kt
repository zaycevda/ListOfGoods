package com.example.listofgoods.domain.usecase

import com.example.listofgoods.domain.model.Goods
import com.example.listofgoods.domain.repository.GoodsRepository

class EditGoodsUseCase(private val repository: GoodsRepository) {
    suspend fun execute(goods: Goods) {
        repository.editGoods(goods = goods)
    }
}