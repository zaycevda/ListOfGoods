package com.example.listofgoods.ui.model

data class GoodsModel(
    val id: Int,
    val name: String,
    val time: Long,
    val tags: List<String>,
    val amount: Int
)