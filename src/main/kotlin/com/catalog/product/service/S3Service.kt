package com.catalog.product.service

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.ObjectMetadata
import org.springframework.stereotype.Service
import java.io.InputStream

@Service
class S3Service (private val amazonS3: AmazonS3){

    fun uploadImage(key: String, inputStream: InputStream, metadata: ObjectMetadata){
        println("uploadImage started")
        amazonS3.putObject("product-microservice-sonofcars", key, inputStream, metadata)
        println("uploadImage Ended")
    }

    fun getImageUrl(key: String): String{
        println("getImageUrl started")
        return amazonS3.getUrl("product-microservice-sonofcars", key).toString()
    }
}