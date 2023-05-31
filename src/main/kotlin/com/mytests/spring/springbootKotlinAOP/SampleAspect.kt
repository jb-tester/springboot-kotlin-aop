package com.mytests.spring.springbootKotlinAOP

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.*
import org.springframework.stereotype.Component


@Aspect
@Component
class SampleAspect {
    @Pointcut("execution(* com.mytests.spring.springbootKotlinAOP.SampleRepo.*(..))")
    fun repositoryMethodsPointcut() {
        // No code required here
    }

    @Pointcut("execution(* com.mytests.spring.springbootKotlinAOP.SampleService.*(..))")
    fun serviceMethodsPointcut() {
        // No code required here
    }

    @Pointcut("execution(* *..find*(String)) || execution(* *..display*(String))")
    fun methodByNamePatternAndParam() {
    }

    @Around("com.mytests.spring.springbootKotlinAOP.SampleAspect.repositoryMethodsPointcut()repositoryMethodsPointcut()")
    @Throws(Throwable::class)
    fun aroundRepoMethodExecution(jp: ProceedingJoinPoint): Any {
        println("============== Test around pointcut for the repo methods =============")
        println("intercepting service method " + jp.signature)
        println("======================================================================")
        return jp.proceed()
    }

    @Before("serviceMethodsPointcut()")
    fun beforeServiceMethodExecution(jp: JoinPoint) {
        println("============== Test before pointcut for the service methods ==========")
        println("intercepting service method " + jp.signature)
        println("======================================================================")
    }

    @After("com.mytests.spring.springbootKotlinAOP.SampleAspect.methodByNamePatternAndParam()")
    fun afterPatternMethod(jp: JoinPoint) {
        println("**********************************")
        println("patern!!! " + jp.signature)
        println("**********************************")
    }
}
