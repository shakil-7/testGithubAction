package com.example.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test-1")
    public String test1() {
        System.out.println("this is test1 in TestController");

        return "retun value of test-1";
    }

    @PostMapping("test-2")
    public String test2(@RequestBody Dto dto) {
        System.out.println("this is test2");
        return dto.getName() + "extra information added";
    }
}
