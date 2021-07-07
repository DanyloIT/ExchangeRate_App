package com.example.exchangerate_app.service;

import com.example.exchangerate_app.model.ApiResponseWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class HttpClient {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> T get(String url, Class<? extends T> clazz) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                System.out.println(result);
                List list = objectMapper.readValue(result, List.class);
                Gson gson = new Gson();
                Type userListType = new TypeToken<ArrayList<ApiResponseWrapper>>(){}.getType();
                ArrayList<ApiResponseWrapper> apiArray = gson.fromJson(result, userListType);
                for(ApiResponseWrapper apiResponseWrapper : apiArray) {
                    System.out.println(apiResponseWrapper);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not send GET request to url " + url, e);
        }
        return null;
    }

    public static void main(String[] args) {
        HttpClient client = new HttpClient();
        ApiResponseWrapper currencyResponseDto = client
                .get("https://api.monobank.ua/bank/currency", ApiResponseWrapper.class);
        System.out.println(currencyResponseDto);
    }
}
