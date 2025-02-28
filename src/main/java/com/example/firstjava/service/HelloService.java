package com.example.firstjava.service;

import com.example.firstjava.repository.HelloRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class HelloService {

    private final HelloRepository helloRepository;
    private final Random random;

    public HelloService(HelloRepository helloRepository, Random random) {
        this.helloRepository = helloRepository;
        this.random = random;
    }

    public String sayHello() {
        String text = "Привет, засранец!";

        int storageCount = helloRepository.getStorageSize();
        String param = helloRepository.sayHello(random.nextInt(storageCount));

        return text + " " + param;
    }
}
