package com.example.listofgoods.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.listofgoods.data.model.GoodsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GoodsDao {
    @Query(value = "SELECT * FROM item WHERE name LIKE :query")
    fun getGoodsList(query: String): Flow<List<GoodsEntity>>

    @Query(value = "DELETE FROM item WHERE id = :id")
    suspend fun deleteGoods(id: Int)

    @Update
    suspend fun editGoods(goods: GoodsEntity)
}