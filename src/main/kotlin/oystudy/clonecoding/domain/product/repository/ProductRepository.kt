package oystudy.clonecoding.domain.product.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import oystudy.clonecoding.domain.product.entity.Product

@Repository
interface ProductRepository : JpaRepository<Product, Long> {

}