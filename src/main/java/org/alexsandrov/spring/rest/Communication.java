package org.alexsandrov.spring.rest;

import org.alexsandrov.spring.rest.entity.Person;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {
    final private RestTemplate restTemplate;
    final private String URL = "http://94.198.50.185:7081/api/users";
    final private HttpHeaders headers = new HttpHeaders();

    public Communication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public List<Person> allPerson() {
        ResponseEntity<List<Person>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET,
                        null, new ParameterizedTypeReference<List<Person>>() {
                        });

        System.out.println(responseEntity.getHeaders());
        System.out.println("----------------------------------------------------------------------------");
        headers.add("Cookie", responseEntity.getHeaders().getFirst("Set-Cookie"));

        return responseEntity.getBody();
    }

    public ResponseEntity<String> postRequest(Person person) {
        HttpEntity<Person> entity = new HttpEntity<>(person, headers);
        ResponseEntity<String> response = restTemplate
                .exchange(URL, HttpMethod.POST, entity, String.class);
        System.out.println(response.getStatusCode());
        System.out.println("----------------------------------------------------------------------------");
        return response;
    }

    public ResponseEntity<String> putRequest(Person person) {
        HttpEntity<Person> entity = new HttpEntity<>(person, headers);
        ResponseEntity<String> response = restTemplate
                .exchange(URL, HttpMethod.PUT, entity, String.class);
        System.out.println(response.getStatusCode());
        System.out.println("----------------------------------------------------------------------------");
        return response;
    }

    public ResponseEntity<String> deletePerson(int id) {
        ResponseEntity<String> response = restTemplate.exchange(URL + "/3", HttpMethod.DELETE,
                new HttpEntity<>(headers), String.class);
        System.out.println(response.getStatusCode());
        System.out.println("----------------------------------------------------------------------------");
        return response;
    }

}
