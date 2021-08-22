package ru.vsibi.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.vsibi.data.api.auth.AuthRepository
import ru.vsibi.data.api.auth.AuthRepositoryImpl
import ru.vsibi.data.api.auth.AuthService
import ru.vsibi.data.api.profile.ProfileRepository
import ru.vsibi.data.api.profile.ProfileRepositoryImpl
import ru.vsibi.data.api.profile.ProfileService

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideAuthRepository(authService : AuthService): AuthRepository {
        return AuthRepositoryImpl(authService)
    }

    @Provides
    fun provideProfileRepository(profileService: ProfileService): ProfileRepository {
        return ProfileRepositoryImpl(profileService)
    }

}