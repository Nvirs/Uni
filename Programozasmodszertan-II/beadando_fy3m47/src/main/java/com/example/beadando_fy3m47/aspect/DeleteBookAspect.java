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
public class DeleteBookAspect {
    
    private final Logger logger = LoggerFactory.getLogger(DeleteBookAspect.class);

    @Before("execution(* com.example.beadando_fy3m47.service.BookService.deleteBook(..)) && args(id)")
    public void beforeDeleteBook(JoinPoint joinPoint, Long id) {
        logger.info("Attempting to delete book with ID: {}", id);
    }

    @After("execution(* com.example.beadando_fy3m47.service.BookService.deleteBook(..)) && args(id)")
    public void afterDeleteBook(JoinPoint joinPoint, Long id) {
        logger.info("Successfully deleted book with ID: {}", id);
    }
} 