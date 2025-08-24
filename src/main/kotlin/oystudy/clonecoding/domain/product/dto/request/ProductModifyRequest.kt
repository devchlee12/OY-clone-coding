package oystudy.clonecoding.domain.product.dto.request

data class ProductModifyRequest(
    val productId: Long,
    val productName: String? = null,
    val brandName: String? = null,
    val productPrice: Int? = null,
    val productStock: Int? = null
)
