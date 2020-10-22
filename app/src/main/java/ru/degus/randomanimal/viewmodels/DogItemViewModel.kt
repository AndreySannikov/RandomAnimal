package ru.degus.randomanimal.viewmodels

import androidx.lifecycle.ViewModel
import ru.degus.randomanimal.models.Animal

class DogItemViewModel : ViewModel() {
    var data: List<Animal> = emptyList()

    fun getMessage(position: Int) = data[position].message

    fun getBreed(position: Int) = data[position].message
        .substringBeforeLast( "/")
        .substringAfterLast("/")

    fun visible(position: Int) = if (position != 0) "invisible" else "visible"
}