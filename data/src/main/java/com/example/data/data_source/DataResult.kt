package com.example.data.data_source

import java.lang.Exception

sealed class DataResult<T> {
    class Success<T>(val data: T) : DataResult<T>()
    class Failure<T>(val message: String) : DataResult<T>()
    class Error<T>(val error: Exception) : DataResult<T>()
}
