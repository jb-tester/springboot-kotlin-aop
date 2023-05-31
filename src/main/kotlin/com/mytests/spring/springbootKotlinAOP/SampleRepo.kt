package com.mytests.spring.springbootKotlinAOP

import org.springframework.data.repository.CrudRepository

interface SampleRepo : CrudRepository<Sample?, Int?> {
    fun findByColor(color: String?): List<Sample?>
}
