package com.catalog.product.config

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AwsConfig {

    @Value("\${cloud.aws.credentials.AWS_ACCESS_KEY_ID}")
    lateinit var accessKey: String

    @Value("\${cloud.aws.credentials.AWS_SECRET_KEY}")
    lateinit var secretKey: String

    @Value("\${cloud.aws.region.static}")
    var region: String = "ue-central-1"


    @Bean
    fun amazonS3(): AmazonS3 {
        val  credential: AWSCredentials = BasicAWSCredentials(accessKey, secretKey)

        return AmazonS3ClientBuilder
            .standard()
            .withCredentials(AWSStaticCredentialsProvider(credential))
            .withRegion(region)
            .build()
    }
}