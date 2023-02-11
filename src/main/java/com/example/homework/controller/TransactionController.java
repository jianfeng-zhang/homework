package com.example.homework.controller;
import com.example.homework.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TransactionController {

    private final TransactionService transactionService;
    @Autowired
    TransactionController( TransactionService transactionService){
        this.transactionService = transactionService;
    }
    @GetMapping("/findPoint")
    public Map<String,int[]> getRewardsById(){
        return transactionService.findAllPoint();
    }
}
