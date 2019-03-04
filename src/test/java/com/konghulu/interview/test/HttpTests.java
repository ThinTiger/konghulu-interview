package com.konghulu.interview.test;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author: za-lining
 * @date: 2019/3/1
 **/
@Slf4j
public class HttpTests extends BaseApplicationTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testGet() {
        String url = "https://example.org";
        Map<String, String> map = Maps.newHashMap();
        map.put("paramA", "test param A");
        map.put("paramB", "test param B");

        try {
            ResponseEntity<JSONObject> response = restTemplate.getForEntity(url + "?paramA={paramA}&paramB={paramB}", JSONObject.class, map);
            log.info("http response:{}", response.getBody().get("columnA"));
        } catch (HttpStatusCodeException ex){
            log.error("http request error", ex);
            log.error("http request error,body:{},status:{}", ex.getResponseBodyAsString(), ex.getStatusCode(), ex);
        } catch (Exception ex){
            log.error("http request error", ex);
        }
    }
}
