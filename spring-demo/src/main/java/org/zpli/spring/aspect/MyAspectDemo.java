package org.zpli.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/4/26 16:43
 */

@Aspect
@Component
public class MyAspectDemo {

    @Pointcut("@annotation(org.zpli.spring.aspect.MyAspect)")
    public void pointCutDeclarationMed() {
    }

    @Pointcut("@within(org.zpli.spring.aspect.MyAspect)")
    public void pointCutDeclarationCls() {
    }

    @Around("pointCutDeclarationMed() || pointCutDeclarationCls()")
    public void execute(ProceedingJoinPoint joinPoint) {

        try {
            System.out.println(joinPoint.getSignature().getName());
            joinPoint.proceed();
            System.out.println("后置通知");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}
