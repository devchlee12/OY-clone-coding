package oystudy.clonecoding.global.exception.dto

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime

data class ApiErrorResponse(
    val status: Int,
    val message: String?,
    val errors: List<FieldError>? = null,
) {
    data class FieldError(
        val field: String,
        val reason: String
    )
}
