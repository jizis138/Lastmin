package ru.vsibi.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.vsibi.data.api.auth.AuthService
import ru.vsibi.data.AuthHelper
import ru.vsibi.data.SharedPreferenceService
import ru.vsibi.data.api.profile.ProfileService
import java.util.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        val retrofit = Retrofit.Builder()
        retrofit.client(okHttpClient)
            .baseUrl("https://apitest.fun:9595")
            .addConverterFactory(GsonConverterFactory.create(gson))
        return retrofit.build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        authInterceptor: Interceptor
    ): OkHttpClient {
        val client = OkHttpClient.Builder()
//        client.protocols(listOf(Protocol.HTTP_1_1))
        client.addInterceptor(authInterceptor)
        client.addInterceptor(httpLoggingInterceptor)
        return client.build()
    }

    @Provides
    @Singleton
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Singleton
    @Provides
    fun authHelper(sharedPreferenceService: SharedPreferenceService): AuthHelper {
        return AuthHelper(sharedPreferenceService)
    }

    @Singleton
    @Provides
    fun authInterceptor(authHelper: AuthHelper): Interceptor {
        return authHelper.getInterceptor()
    }

    @Provides
    fun provideAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Provides
    fun provideProfileService(retrofit: Retrofit): ProfileService {
        return retrofit.create(ProfileService::class.java)
    }

}