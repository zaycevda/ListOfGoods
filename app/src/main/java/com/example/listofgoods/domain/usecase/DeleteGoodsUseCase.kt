package com.example.listofgoods.domain.usecase

import com.example.listofgoods.domain.repository.GoodsRepository

class DeleteGoodsUseCase(private val repository: GoodsRepository) {
    suspend fun execute(id: Int) {
        repository.deleteGoods(id = id)
    }
}