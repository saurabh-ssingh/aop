package com.aop.aop.service;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Log4j2
public class LoggingAspectTest {

  @Autowired
  private MyService myService;

  @Test
  void testPerformOperation() {
    myService.performOperation(6);
  }

  @Test
  void testThrowException() {
    Exception exception = assertThrows(RuntimeException.class, () -> myService.throwException());
    assertEquals("An error occurred while performing operation!", exception.getMessage());

  }
}
