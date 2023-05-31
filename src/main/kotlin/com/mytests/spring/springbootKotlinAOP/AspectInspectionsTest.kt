package com.mytests.spring.springbootKotlinAOP

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before

@Aspect
//@Component
class AspectInspectionsTest {
    @Around("execution(* *.*(..))") // Expected Warning: Join point return value will be lost
    fun voidAround() {
    }

    @Around("execution(* *.*(..))") // Expected Warning: Advice call cannot proceed: probably you forgot to declare a ProceedingJoinPoint parameter
    fun noParamAround(): Any {
        return ""
    }

    @Around("execution(* *.*(..))") // Expected Warning: argNames attribute isn't defined
    @Throws(Throwable::class)
    fun noArgNamesAround(pjp: ProceedingJoinPoint, jp: JoinPoint?): Any {
        return pjp.proceed()
    }

    @Around("execution(* *.*(..))") // Expected Error: Unbound pointcut parameter 'o'
    @Throws(Throwable::class)
    fun noArgNamesAround(pjp: ProceedingJoinPoint, o: Any?): Any {
        return pjp.proceed()
    }

    @Before(value = "execution(* *.*(..))", argNames = "o") // Expected Error: Unbound pointcut parameter 'o'
    fun before1(o: Any?) {
        // ...
    }

    @Before(value = "execution(* *.*(..)) && args(s)", argNames = "s,o") // Expected Error: Unbound pointcut parameter 'o'
    fun before2(s: String?, o: Any?) {
        // ...
    }
}
