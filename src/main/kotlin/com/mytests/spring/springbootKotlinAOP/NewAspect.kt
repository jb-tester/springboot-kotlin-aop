package com.mytests.spring.springbootKotlinAOP

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component


@Aspect
@Component
class NewAspect {

    @After("@annotation(MyMethodAnno)")
    fun afterAnnotatedMethod(jp:JoinPoint){
        println("============== Test after pointcut for the methods annotated with @MyMethodAnno ===")
        println("intercepting method " + jp.signature)
        println("====================================================================================")
    }
    @Before(value = "within(SampleService)")
    fun testInspections(jp: JoinPoint) {
        println("**********************************")
        println("before method within class, method is " + jp.signature)
        println("**********************************")
    }
}