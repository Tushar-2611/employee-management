package com.tushar.employee_management.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Map<String, Object> employee() {
        return Map.of(
                "id", 1,
                "name", "Tushar",
                "department", "Engineering");
    }
}