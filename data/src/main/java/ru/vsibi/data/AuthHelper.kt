package ru.vsibi.data

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import javax.inject.Inject

class AuthHelper @Inject constructor(private val sharedPreferenceService: SharedPreferenceService) {

    init {
        val token = sharedPreferenceService.getSpString(SharedPreferenceService.KEY_ACCESS_TOKEN)
        Log.d(TAG, "token : $token")
        token?.let {
            setupAccessToken(it)
        }
    }

    companion object {
        const val HEADER_ACCEPT = "Accept"
        const val HEADER_AUTH = "Authorization"
        val TAG: String = this.javaClass.simpleName
    }

    private var accessToken: String? = null

    fun getInterceptor(): Interceptor {
        return Interceptor { chain ->
            val interceptRequest: Request =
                chain.request()
                    .newBuilder()
                    .addHeader(HEADER_ACCEPT, "application/json")
                    .addHeader(HEADER_AUTH, "$accessToken")
                    .build()
            chain.proceed(interceptRequest)
        }
    }

    fun setupAccessToken(token: String) {
        this.accessToken = token
    }
}