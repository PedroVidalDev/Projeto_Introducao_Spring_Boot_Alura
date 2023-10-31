package com.pedro.demo.domain.schedule;

public class ValidationExceptionSchedule extends RuntimeException {
    public ValidationExceptionSchedule(String s) {
        super(s);
    }
}
