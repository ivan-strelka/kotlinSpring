package ru.strelka.exception

data class ApiError(
    val errorCode: String,
    val description: String,
)
