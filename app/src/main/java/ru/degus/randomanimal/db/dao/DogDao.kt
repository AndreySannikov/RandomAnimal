package ru.degus.randomanimal.db.dao

import androidx.room.*
import ru.degus.randomanimal.db.entity.DogDB


@Dao
interface DogDao{
    @get:Query("SELECT * FROM DogDB")
    val all: List<Any?>?

    @Query("SELECT * FROM DogDB WHERE id = :id")
    fun getById(id: Long): DogDB?

    @Insert
    fun insert(employee: DogDB?)

    @Update
    fun update(employee: DogDB?)

    @Delete
    fun delete(employee: DogDB?)
}