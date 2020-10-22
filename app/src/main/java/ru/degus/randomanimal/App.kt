package ru.degus.randomanimal

import android.app.Application
import androidx.room.Room
import ru.degus.randomanimal.db.database.AppDatabase
import javax.inject.Inject


class App : Application () {
    var database: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .build()
    }

    companion object {
        var instance: App? = null
    }
}