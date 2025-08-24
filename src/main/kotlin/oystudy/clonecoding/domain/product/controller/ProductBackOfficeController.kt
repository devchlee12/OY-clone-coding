package oystudy.clonecoding.domain.product.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import oystudy.clonecoding.domain.product.dto.request.ProductModifyRequest
import oystudy.clonecoding.domain.product.dto.request.ProductRegisterRequest
import oystudy.clonecoding.domain.product.service.ProductModifyService
import oystudy.clonecoding.domain.product.service.ProductRegisterService
import oystudy.clonecoding.global.dto.ApiSuccessResponse

@RestController
@RequestMapping("/backoffice/products")
class ProductBackOfficeController(
    val productModifyService: ProductModifyService,
    val productRegisterService: ProductRegisterService
) {

    @PostMapping("/register")
    fun registerProduct(@RequestBody productRegisterRequest: ProductRegisterRequest)
    : ResponseEntity<ApiSuccessResponse<Unit>> {
        productRegisterService.registerProduct(
            productName = productRegisterRequest.productName,
            brandName = productRegisterRequest.brandName,
            productPrice = productRegisterRequest.productPrice,
            productStock = productRegisterRequest.productStock
        )

        return ResponseEntity.ok(ApiSuccessResponse())
    }

    @PutMapping("/modify")
    fun modifyProduct(@RequestBody productModifyRequest: ProductModifyRequest)
    :ResponseEntity<ApiSuccessResponse<Unit>> {
        productModifyService.modifyProduct(productModifyRequest)
        return ResponseEntity.ok(ApiSuccessResponse())
    }
}