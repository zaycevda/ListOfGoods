package com.example.listofgoods.domain.repository

import com.example.listofgoods.domain.model.Goods
import kotlinx.coroutines.flow.Flow

interface GoodsRepository {
    fun getGoodsList(query: String): Flow<List<Goods>>

    suspend fun deleteGoods(id: Int)

    suspend fun editGoods(goods: Goods)
}