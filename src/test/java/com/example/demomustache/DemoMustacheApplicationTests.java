package com.example.demomustache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoMustacheApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void givenIndexPage_whenContainsArticle_thenTrue() {

        ResponseEntity<String> entity
                = this.restTemplate.getForEntity("/article", String.class);

        assertTrue(entity.getStatusCode()
                .equals(HttpStatus.OK));
        assertTrue(entity.getBody()
                .contains("Article Title 0"));
    }

}
