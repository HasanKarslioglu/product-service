package com.catalog.product.controller

import com.catalog.product.model.Product
import com.catalog.product.service.ProductService
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
class ProductController(private val productService: ProductService) {

    @GetMapping("/products")
    fun getProducts(@RequestParam("page") pageNumber: Int, @RequestParam("size") pageSize: Int): Page<Product> {
        return productService.getAllProduct(pageNumber, pageSize)
    }

    @PostMapping("/products")
    fun createProduct(@RequestPart("product") product: Product, @RequestPart("image") image: MultipartFile): ResponseEntity<Product>{
        val savedProduct = productService.saveProduct(product)
        return ResponseEntity(savedProduct, HttpStatus.CREATED)
    }
}
