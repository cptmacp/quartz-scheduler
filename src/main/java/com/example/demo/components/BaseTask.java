package com.example.demo.components;


import jakarta.transaction.Transactional;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@SuperBuilder
@Transactional
public class BaseTask {


    int a;


    public CompletableFuture<List<String>> perform(String a) {


        CompletableFuture<List<String>> taskResultList = new CompletableFuture<>();

        return taskResultList;


    }


    public List<String> perform2(String a) {


        List<String> taskResultList = new ArrayList<>();

        return taskResultList;


    }
}
