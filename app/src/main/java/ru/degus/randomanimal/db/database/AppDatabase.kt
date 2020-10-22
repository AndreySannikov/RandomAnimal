package ru.degus.randomanimal.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.degus.randomanimal.db.dao.DogDao
import ru.degus.randomanimal.db.entity.DogDB

@Database(entities = [DogDB::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dogDao(): DogDao?
}