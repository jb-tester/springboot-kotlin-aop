package com.mytests.spring.springbootKotlinAOP

import org.springframework.stereotype.Service


@Service
class SampleService(private val repo: SampleRepo) {
    fun displayAllSamples() {
        println("all samples:")
        for (sample in repo.findAll()) {
            println(sample)
        }
    }
   @MyMethodAnno
    fun displayByColor(color: String) {
        println("all samples with $color color:")
        for (sample in repo.findByColor(color)) {
            println(sample)
        }
    }


}
