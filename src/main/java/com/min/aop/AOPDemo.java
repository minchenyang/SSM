package com.min.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @program: SSM
 * @description:
 * @author: mcy
 * @create: 2018-06-25 18:12
 **/

/**
 * @Before("方法名")   // 前置通知
 * @After("方法名') //后置通知 (异常会执行)
 * @AfterReturning("方法名") //返回后通知  (异常不会执行)
 * @AfterThrowing("方法名")  //目标方法异常时执行
 * @Around("方法名")  //环绕通知
 */
@Component
@Aspect
public class AOPDemo {
    @Pointcut("execution(* *.saying(..))")
    public void sayings(){}

    @Before("sayings()")
    public void sayHello(){
        System.out.println("注解类型前置通知");
    }

    @After("sayings()")
    public void sayGoodbey(){
        System.out.println("注解类型后置通知");
    }

    @Around("sayings()")
    public void sayAround (ProceedingJoinPoint pjp)throws Throwable{
        System.out.println("注解类型环绕通知..环绕前");
        pjp.proceed();//执行方法
        System.out.println("注解类型环绕通知..环绕后");
    }

}
