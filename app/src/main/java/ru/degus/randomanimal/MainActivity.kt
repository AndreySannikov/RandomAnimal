package ru.degus.randomanimal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import ru.degus.randomanimal.db.database.AppDatabase
import ru.degus.randomanimal.fragments.DogFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, DogFragment.newInstance())
                    .commitNow()
        }


    }
}