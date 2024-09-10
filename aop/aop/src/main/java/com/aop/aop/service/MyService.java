package com.aop.aop.service;

import com.aop.aop.annotation.TimeTrack;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MyService {


    public String throwException() {
        throw new RuntimeException("An error occurred while performing operation!");
    }

    @TimeTrack
    public void performOperation(int number) {
        if(number >= 5){
            // Simulating a time-consuming operation
            try {
                Thread.sleep(1000); // Simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Number is greater than or equal to 5");
        } else {
            throw new RuntimeException("Number is less than 5");
        }
    }
}
