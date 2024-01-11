package com.exam.aspect;

import com.exam.entities.LogEntity;
import com.exam.repositories.LogsRepo;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Aspect
@Component
@RequiredArgsConstructor
public class LoggingAspect {


    private final LogsRepo logsRepo;

    @Around("@annotation(com.exam.aspect.Loggable)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        try {
            return joinPoint.proceed();
        } finally {
            long executionTime = System.currentTimeMillis() - startTime;

            String className = joinPoint.getSignature().getDeclaringTypeName();
            String methodName = joinPoint.getSignature().getName();

            LogEntity logEntity = LogEntity.builder()
                    .logCreationDate(Instant.now())
                    .className(className)
                    .methodName(methodName)
                    .methodExecutionMillis(executionTime)
                    .build();

            logsRepo.save(logEntity);
        }
    }
}