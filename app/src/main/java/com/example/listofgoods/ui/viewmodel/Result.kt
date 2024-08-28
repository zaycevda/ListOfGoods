package com.example.listofgoods.ui.viewmodel

import androidx.compose.runtime.Composable

typealias OnLoading = () -> Unit
typealias OnSuccess<T> = (T) -> Unit
typealias OnFailure = (Throwable) -> Unit

sealed class Result<out T> {
    data object Loading : Result<Nothing>()
    data class Success<out T>(val data: T) : Result<T>()
    data class Failure(val throwable: Throwable) : Result<Nothing>()

    fun onLoading(onLoading: OnLoading): Result<T> {
        if (this is Loading) {
            onLoading()
        }
        return this
    }

    @Composable
    fun onSuccess(onSuccess: @Composable OnSuccess<T>): Result<T> {
        if (this is Success) {
            onSuccess(data)
        }
        return this
    }

    fun onFailure(onFailure: OnFailure): Result<T> {
        if (this is Failure) {
            onFailure(throwable)
        }
        return this
    }
}