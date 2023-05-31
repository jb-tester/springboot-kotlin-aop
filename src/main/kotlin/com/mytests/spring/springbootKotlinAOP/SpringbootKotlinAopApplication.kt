package com.mytests.spring.springbootKotlinAOP

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringbootKotlinAopApplication(private val callService: CallService) :CommandLineRunner{
    override fun run(vararg args: String?) {
        callService.displayAll()
    }

}

fun main(args: Array<String>) {
    runApplication<SpringbootKotlinAopApplication>(*args)

}
