package ru.vsibi.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.vsibi.data.api.auth.AuthRepository
import ru.vsibi.data.api.auth.AuthRepositoryImpl
import ru.vsibi.data.api.auth.AuthService

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideAuthRepository(authService : AuthService): AuthRepository {
        return AuthRepositoryImpl(authService)
    }

}