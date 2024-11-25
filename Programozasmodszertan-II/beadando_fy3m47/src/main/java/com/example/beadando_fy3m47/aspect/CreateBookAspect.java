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
public class CreateBookAspect {
    
    private final Logger logger = LoggerFactory.getLogger(CreateBookAspect.class);

    @Before("execution(* com.example.beadando_fy3m47.service.BookService.createBook(..)) && args(book)")
    public void beforeCreateBook(JoinPoint joinPoint, Object book) {
        logger.info("Attempting to create new book: {}", book);
    }

    @After("execution(* com.example.beadando_fy3m47.service.BookService.createBook(..)) && args(book)")
    public void afterCreateBook(JoinPoint joinPoint, Object book) {
        logger.info("Successfully created new book: {}", book);
    }
} 