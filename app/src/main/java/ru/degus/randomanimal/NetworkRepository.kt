package ru.degus.randomanimal

import android.util.Log
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.degus.randomanimal.models.Animal
import javax.inject.Inject


class NetworkRepository @Inject constructor() {

    private val remote: DogService = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(DogService::class.java)


    fun loadAnimal(): Animal {
        var dog = Animal("not initialized", "")
        remote.getAnimal()
            .subscribeOn(Schedulers.io())
            .subscribe({ t: Animal? ->
                Log.d("M_MainFragment","${t?.message}")
                if (t != null) {
                    dog.message = t.message
                }
            }, { t: Throwable? ->
                Log.d("M_MainFragment","error")
                dog = Animal("error", "")
            })
        return dog
    }
}