package oystudy.clonecoding.domain.product.entity

import jakarta.persistence.*

@Entity
@Table(name = "product")
class Product (
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "product_name",nullable = false, length = 50)
    var productName: String,

    @Column(name = "product_brand_name",nullable = false, length = 10)
    var brandName: String,

    @Column(name = "product_price", nullable = false)
    var price: Int,

    @Column(name = "product_stock",nullable = false)
    var stock: Int
)