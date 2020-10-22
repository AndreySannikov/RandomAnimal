package ru.degus.randomanimal.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class DogDB (
    @PrimaryKey
    var id: Long = 0,
    var message: String = "",
    var breed: String = ""
)
