package oystudy.clonecoding.domain.product.dto.request

data class ProductRegisterRequest(
    val productName: String,
    val brandName: String,
    val productPrice: Int,
    val productStock: Int
)
