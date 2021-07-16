package ru.vsibi.data

import okhttp3.Interceptor
import okhttp3.Request

class AuthHelper {

    companion object {
        const val HEADER_ACCEPT = "Accept"
        const val HEADER_AUTH = "Authorization"
    }

    private var accessToken: String? = null

    fun getInterceptor(): Interceptor {
        return Interceptor { chain ->
            val interceptRequest: Request =
                chain.request()
                    .newBuilder()
                    .addHeader(HEADER_ACCEPT, "application/json")
                    .addHeader(HEADER_AUTH, "Bearer $accessToken")
                    .build()
            chain.proceed(interceptRequest)
        }
    }

    fun setupAccessToken(token: String) {
        this.accessToken = token
    }
}