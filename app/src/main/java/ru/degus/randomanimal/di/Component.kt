package ru.degus.randomanimal.di

import dagger.Component
import ru.degus.randomanimal.NetworkRepository

@Component
interface Component {
    fun getNetworkRepository() : NetworkRepository
}