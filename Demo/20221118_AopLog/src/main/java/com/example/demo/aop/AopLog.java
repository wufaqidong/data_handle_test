package com.example.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: a-rookie-is-a-god
 * @description: 测试aop
 * @author: xiebinbin
 * @create: 2022-11-18 13:39
 */
@Aspect
@Component
@Slf4j
public class AopLog {

  // 线程的局部变量，解决多线程中相同变量的访问冲突问题
  ThreadLocal<Long> startTime = new ThreadLocal<>();

  // 定义切点
  @Pointcut("execution(public * com.example..*.*(..))")
  public void aopWebLog() {}

  @Before("aopWebLog()")
  public void doBeFore(JoinPoint joinPoint) throws Throwable {
    startTime.set(System.currentTimeMillis());
    // 接收到请求，记录请求内容
    ServletRequestAttributes attributes =
        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

    HttpServletRequest request = attributes.getRequest();
    log.info("URL：" + request.getRequestURI());
    log.info("HTTP方法：" + request.getMethod());
    log.info("URL：" + request.getRequestURI());
    log.info("URL：" + request.getRequestURI());
    log.info("URL：" + request.getRequestURI());
  }
}
