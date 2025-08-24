package oystudy.clonecoding.global.dto

data class ApiSuccessResponse<T> (
    val status: Int = 200,
    val data: T? = null
)