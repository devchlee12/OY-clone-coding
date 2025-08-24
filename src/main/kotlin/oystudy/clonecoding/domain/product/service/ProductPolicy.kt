package oystudy.clonecoding.domain.product.service

import org.springframework.stereotype.Component
import oystudy.clonecoding.domain.product.entity.Product

@Component
class ProductPolicy {
    fun validateProduct(product: Product) {
        require(product.productName.length <= 50) {"상품 이름의 길이는 50자 이하여야 합니다."}
        require(product.brandName.length <= 10) {"상품 브랜드 명칭은 10자 이하여야 합니다."}
        require(product.price <= 500000) {"상품의 가격은 500000원 이하여야 합니다."}
        require(product.price >= 0) {"상품의 가격은 음수가 될 수 없습니다."}
    }
}