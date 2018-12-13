package com.wassi.camprandoapp.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author Hamza Jeljeli
 * Disclaimer : Since programmers over the world have found a severe problem implementing a Generic
 * Class that would make a call to a Remote Webservice and retrieve some data in Json format.
 * I'll be publishing this code to public.
 */

public class WsCommunicator {
    /**
     * @param url             is the URI address of the WebService
     * @param parameterObject the object where all parameters are passed.
     * @param returnType      the return type you are expecting. Exemple : someClass.class
     */

    public static <T> T getObject(String url, Object parameterObject, Class<T> returnType) {
        try {
            ResponseEntity<T> res;
            ObjectMapper mapper = new ObjectMapper();
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(2000);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<T> entity = new HttpEntity<T>((T) parameterObject, headers);
            return restTemplate.exchange(url, org.springframework.http.HttpMethod.POST, entity, returnType).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param url             is the URI address of the WebService
     * @param parameterObject the object where all parameters are passed.
     * @param returnType      the type of the returned object. Must be an array. Exemple : someClass[].class
     */
    public static <T> List<T> getListOfObjects(String url, Object parameterObject, Class<T[]> returnType) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(2000);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<T> entity = new HttpEntity<T>((T) parameterObject, headers);
            ResponseEntity<Object[]> results = restTemplate.exchange(url, org.springframework.http.HttpMethod.POST, entity, Object[].class);
            String json = mapper.writeValueAsString(results.getBody());
            T[] arr = new Gson().fromJson(json, returnType);
            return Arrays.asList(arr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
