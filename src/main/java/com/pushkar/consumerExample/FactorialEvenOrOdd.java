package com.pushkar.consumerExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;

@RestController
public class FactorialEvenOrOdd {

    RestTemplate template = new RestTemplate();

    @GetMapping(path = "/evenorodd")
    public String checkOddAndEven(@RequestParam("number") Integer number) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");

        ResponseEntity<String> responseEntity = template.exchange(
                "http://localhost:8080/factorial?number="+number,
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                String.class);

        BigInteger bigInteger = new BigInteger(responseEntity.getBody());

        BigInteger[] bigIntegers = bigInteger.divideAndRemainder(new BigInteger("2"));




        return bigIntegers[1].intValue() == 0 ? "Even" : "Odd";
    }
}
