package ru.degus.randomanimal

import io.reactivex.Single
import retrofit2.http.GET
import ru.degus.randomanimal.models.Animal

interface DogService {
    @GET("breeds/image/random")
    fun getAnimal(): Single<Animal> //@Query("message") message: String, @Query("status") status: String
}