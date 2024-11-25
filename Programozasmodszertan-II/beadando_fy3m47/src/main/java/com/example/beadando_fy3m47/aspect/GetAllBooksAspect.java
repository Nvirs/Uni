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
public class GetAllBooksAspect {
    
    private final Logger logger = LoggerFactory.getLogger(GetAllBooksAspect.class);

    @Before("execution(* com.example.beadando_fy3m47.service.BookService.getAllBooks())")
    public void beforeGetAllBooks(JoinPoint joinPoint) {
        logger.info("Attempting to retrieve all books");
    }

    @After("execution(* com.example.beadando_fy3m47.service.BookService.getAllBooks())")
    public void afterGetAllBooks(JoinPoint joinPoint) {
        logger.info("Successfully retrieved all books");
    }
} 