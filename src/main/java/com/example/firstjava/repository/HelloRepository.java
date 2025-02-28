package com.example.firstjava.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class HelloRepository {

    Map<Integer, String> storage = new HashMap<>() {{
        put(0, "привет");
        put(1, "пока");
        put(2, "креветка");
        put(3, "чемодан");
    }};

    public String sayHello(int rand) {
        return storage.get(rand);
    }

    public int getStorageSize() {
        return storage.size();
    }
}
