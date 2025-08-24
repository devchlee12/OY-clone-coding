package oystudy.clonecoding.global.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import oystudy.clonecoding.global.exception.dto.ApiErrorResponse

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(
        e: IllegalArgumentException
    ): ResponseEntity<ApiErrorResponse> {
        val body = ApiErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            e.message ?: "알 수 없는 도메인 에러"
        )

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValid(
        e: MethodArgumentNotValidException,
    ): ResponseEntity<ApiErrorResponse> {
        val fieldErrors = e.bindingResult.fieldErrors.map { fe ->
            ApiErrorResponse.FieldError(
                field = fe.field,
                reason = fe.defaultMessage ?: "Invalid value"
            )
        }

        val body = ApiErrorResponse(
            status = HttpStatus.BAD_REQUEST.value(),
            message = "DTO 검증 실패",
            errors = fieldErrors
        )
        return ResponseEntity.badRequest().body(body)
    }

    @ExceptionHandler(Exception::class)
    fun handleOthers(
        e: Exception,
    ): ResponseEntity<ApiErrorResponse> {
        val body = ApiErrorResponse(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            message = e.message ?: "알 수 없는 내부 에러"
        )
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body)
    }

}