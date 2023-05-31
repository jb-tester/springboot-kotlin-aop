package com.mytests.spring.springbootKotlinAOP

import org.springframework.stereotype.Service

/**
 **
 * <p>Created by irina on 5/24/2023.</p>
 * <p>Project: springboot-kotlin-aop</p>
 **
 */
@Service
class CallService(private val sampleService: SampleService) {

    fun displayAll() {
        sampleService.displayAllSamples()
        sampleService.displayByColor("red")
    }
}