package ru.degus.randomanimal.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.degus.randomanimal.NetworkRepository
import ru.degus.randomanimal.di.DaggerComponent
import ru.degus.randomanimal.models.Animal

class DogViewModel : ViewModel() {
    lateinit var animal : Animal
    val dogs = MutableLiveData<List<Animal>>()
    private val repository = DaggerComponent.create().getNetworkRepository()
    private val animals : MutableList<Animal> = listOf(Animal("test", "teest")).toMutableList()


    fun loadDogs() {
        animal = repository.loadAnimal()
        animals.add(animal)
        dogs.postValue(animals)
    }

    fun removeDog() {
        animals.removeAt(0)
        dogs.postValue(animals)
    }

}