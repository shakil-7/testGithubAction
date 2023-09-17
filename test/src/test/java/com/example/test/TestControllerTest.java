package com.example.test;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Test;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestPropertySource(properties = "logging.level.root=ERROR")
class TestControllerTest {

    @Autowired
    private TestController testController;

    @Test
    void test1() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Request> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> responseDTO = new RestTemplate().exchange("http://localhost:9999/test-1", HttpMethod.GET, entity, String.class);

        System.out.println("responseDTO test-1 = " + responseDTO.getBody());
    }

    @Test
    void test2() {

        Dto dto = new Dto();
        dto.setName("some name");

        String response = sendHttpRequest("http://localhost:9999/test-2", HttpMethod.POST, dto, String.class);
        System.out.println("response test-2 = " + response);
    }


    public static <Request, Response> Response sendHttpRequest(String url, HttpMethod httpMethod, Request req, Class<Response> res) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Request> entity = new HttpEntity<>(req,headers);
        ResponseEntity<Response> responseDTO = new RestTemplate().exchange(url, httpMethod, entity, res);
        return responseDTO.getBody();
    }
}