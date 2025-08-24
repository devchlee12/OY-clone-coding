package oystudy.clonecoding.domain.product.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import oystudy.clonecoding.domain.product.dto.request.ProductModifyRequest
import oystudy.clonecoding.domain.product.repository.ProductRepository

@Service
class ProductModifyService(
    private val productPolicy : ProductPolicy,
    private val productRepository : ProductRepository
) {

    @Transactional
    fun modifyProduct(productModifyRequest: ProductModifyRequest){
        val productId = productModifyRequest.productId
        productModifyRequest.productName?.let { modifyProductName(productId, it) }
        productModifyRequest.brandName?.let { modifyBrandName(productId, it) }
        productModifyRequest.productPrice?.let { modifyProductPrice(productId, it) }
        productModifyRequest.productStock?.let { modifyProductStock(productId, it) }
    }

    private fun modifyProductPrice(id:Long, price:Int) {
        val product = productRepository.findById(id).orElseThrow{
            IllegalArgumentException("id $id 에 대한 상품이 존재하지 않습니다.")
        }
        product.price = price
        productPolicy.validateProduct(product)
    }

    private fun modifyBrandName(id:Long, brandName:String) {
        val product = productRepository.findById(id).orElseThrow{
            IllegalArgumentException("id $id 에 대한 상품이 존재하지 않습니다.")
        }
        product.brandName = brandName
        productPolicy.validateProduct(product)
    }

    private fun modifyProductName(id:Long, productName:String) {
        val product = productRepository.findById(id).orElseThrow{
            IllegalArgumentException("id $id 에 대한 상품이 존재하지 않습니다.")
        }
        product.productName = productName
        productPolicy.validateProduct(product)
    }

    private fun modifyProductStock(id:Long, stock:Int) {
        val product = productRepository.findById(id).orElseThrow{
            IllegalArgumentException("id $id 에 대한 상품이 존재하지 않습니다.")
        }
        product.stock = stock
        productPolicy.validateProduct(product)
    }
}