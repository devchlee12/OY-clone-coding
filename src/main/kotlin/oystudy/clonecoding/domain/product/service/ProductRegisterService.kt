package oystudy.clonecoding.domain.product.service

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import oystudy.clonecoding.domain.product.entity.Product
import oystudy.clonecoding.domain.product.repository.ProductRepository

@Service
class ProductRegisterService (
    private val productRepository : ProductRepository,
    private val productPolicy : ProductPolicy
){

    @Transactional
    fun registerProduct(productName:String, brandName:String, productPrice:Int, productStock:Int) {
        val product = Product(null,productName,brandName,productPrice,productStock)
        productPolicy.validateProduct(product)
        productRepository.save(product)
    }
}