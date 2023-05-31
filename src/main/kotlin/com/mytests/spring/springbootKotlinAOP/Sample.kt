package com.mytests.spring.springbootKotlinAOP

import jakarta.persistence.*
import java.util.*

/**
 * *
 *
 * Created by irina on 5/24/2023.
 *
 * Project: springboot-java-aop
 * *
 */
@Entity
@Table(name = "sample", schema = "jbtests")
class Sample {
    @get:Column(name = "id")
    @get:Id
    @get:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0

    @get:Column(name = "version")
    @get:Basic
    var version: Int? = null

    @get:Column(name = "sample")
    @get:Basic
    var sample: String? = null

    @get:Column(name = "color")
    @get:Basic
    var color: String? = null
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as Sample
        return id == that.id && version == that.version && sample == that.sample && color == that.color
    }

    override fun hashCode(): Int {
        return Objects.hash(id, version, sample, color)
    }

    override fun toString(): String {
        return "Sample{" +
                "id=" + id +
                ", version=" + version +
                ", sample='" + sample + '\'' +
                ", color='" + color + '\'' +
                '}'
    }
}
