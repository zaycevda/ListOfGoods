package com.example.listofgoods.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.listofgoods.data.utils.Converters
import com.example.listofgoods.data.dao.GoodsDao
import com.example.listofgoods.data.model.GoodsEntity

@Database(
    entities = [GoodsEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class GoodsDatabase : RoomDatabase() {
    abstract fun goodsDao(): GoodsDao
}