package ru.vsibi.helper

import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class RemoteRepository<T> {

    companion object {
        const val ERROR_CODE_INTERNET = -1
        const val ERROR_CODE_NOT_FOUND = 404
    }

    inline fun request(accept: () -> T?): Resource<T> = try {
        val result = accept()
        if (result != null) {
            if ((result as Response<*>).isSuccessful) {
                Resource.success(code = result.code(), data = result)
            } else {
                Resource.error(createError(result.code(), result.message()))
            }
        } else {
            Resource.error(createError(ERROR_CODE_NOT_FOUND, ""))
        }
    } catch (e: HttpException) {
        Resource.error(createError(e.code(), e.localizedMessage))
    } catch (e: IOException) {
        Resource.error(createError(ERROR_CODE_INTERNET, ""))
    } catch (e: Exception) {
        Resource.error(createError(ERROR_CODE_NOT_FOUND, ""))
    }

    fun createError(code: Int, message: String): IError {
        return Error(code = code, message = message, resource = getStringFromCode(code))
    }

    fun getStringFromCode(code: Int): Int {
        when (code) {
            else -> {
                return R.string.something_went_wrong
            }
        }
    }
}