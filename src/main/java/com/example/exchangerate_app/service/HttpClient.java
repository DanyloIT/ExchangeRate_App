package com.example.exchangerate_app.service;

import com.example.exchangerate_app.model.ApiResponseWrapperMinFin;
import com.example.exchangerate_app.model.ApiResponseWrapperMono;
import com.example.exchangerate_app.model.ApiResponseWrapperPrivat;
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
    private final ObjectMapper objectMapper;

    public HttpClient(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ApiResponseWrapperMono[] getMono(String monoUrl, Class<ApiResponseWrapperMono[]> monoClazz) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(monoUrl);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                return objectMapper.readValue(result, ApiResponseWrapperMono[].class);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not send GET request to url " + monoUrl, e);
        }
        return null;
    }

    public ApiResponseWrapperPrivat[] getPrivat(String privatUrl, Class<ApiResponseWrapperPrivat[]> privatClazz) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(privatUrl);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                return objectMapper.readValue(result, ApiResponseWrapperPrivat[].class);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not send GET request to url " + privatUrl, e);
        }
        return null;
    }

    public ApiResponseWrapperMinFin[] getMinFin(String minFinUrl, Class<ApiResponseWrapperMinFin[]> minFinClazz) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(minFinUrl);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                return objectMapper.readValue(result, ApiResponseWrapperMinFin[].class);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not send GET request to url " + minFinUrl, e);
        }
        return null;
    }
}
