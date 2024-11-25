package com.example.beadando_fy3m47.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UpdateBookAspect {
    
    private final Logger logger = LoggerFactory.getLogger(UpdateBookAspect.class);

    @Before("execution(* com.example.beadando_fy3m47.service.BookService.updateBook(..)) && args(id, book)")
    public void beforeUpdateBook(JoinPoint joinPoint, Long id, Object book) {
        logger.info("Attempting to update book with ID: {}, New data: {}", id, book);
    }

    @After("execution(* com.example.beadando_fy3m47.service.BookService.updateBook(..)) && args(id, book)")
    public void afterUpdateBook(JoinPoint joinPoint, Long id, Object book) {
        logger.info("Successfully updated book with ID: {}", id);
    }
} 