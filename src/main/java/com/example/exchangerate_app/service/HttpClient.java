package com.example.exchangerate_app.service;

import com.example.exchangerate_app.model.ApiResponseWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class HttpClient {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ApiResponseWrapper[] get(String url, Class<ApiResponseWrapper[]> clazz) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                return objectMapper.readValue(result, ApiResponseWrapper[].class);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not send GET request to url " + url, e);
        }
        return null;
    }
}
