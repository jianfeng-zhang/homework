package com.example.homework.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface TransactionService {
    Map<String, int[]> findAllPoint();
}
