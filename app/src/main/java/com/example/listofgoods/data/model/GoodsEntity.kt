package com.example.listofgoods.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item")
data class GoodsEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val time: Long,
    val tags: List<String>,
    val amount: Int
)