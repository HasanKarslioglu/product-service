package com.catalog.product.service

import com.amazonaws.services.s3.model.ObjectMetadata
import com.catalog.product.model.Product
import com.catalog.product.repository.ProductRepository
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.io.InputStream
import java.util.*


@Service
class ProductService(private val productRepository: ProductRepository, private val s3Service: S3Service) {

    @Cacheable("productcache")
    fun getAllProduct(pageNumber: Int, pageSize: Int): Page<Product> {
        val pageRequest = PageRequest.of(pageNumber, pageSize)
        return productRepository.findAll(pageRequest)
    }

    @CacheEvict(value = ["productcache"], allEntries = true)
    fun saveProduct(product: Product, inputStream: InputStream, metadata: ObjectMetadata): Product{
        val imageKey = generateImageKey()
        s3Service.uploadImage(imageKey, inputStream, metadata)
        product.photoUrl = s3Service.getImageUrl(imageKey)
        return productRepository.save(product)
    }

    private fun generateImageKey(): String {
        return UUID.randomUUID().toString()
    }

}