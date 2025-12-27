package com.misc.service;

import org.springframework.stereotype.Component;

@Component
public class SumServiceImpl implements SumService {
    @Override
    public int sum(Integer a, Integer b) {
        return a + b;
    }
}
