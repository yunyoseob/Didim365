package com.rwk.kafkaproducer.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestUtil {
    private final Logger logger = LoggerFactory.getLogger(RestUtil.class);

    private final HttpComponentsClientHttpRequestFactory httpRequestFactory;
    private final int CONNECTION_TIMEOUT = 30000; // 30s

    public RestUtil() {
        httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setReadTimeout(CONNECTION_TIMEOUT);
        httpRequestFactory.setConnectTimeout(CONNECTION_TIMEOUT);
        httpRequestFactory.setConnectionRequestTimeout(CONNECTION_TIMEOUT);
    }

    public Object post(String url, Object body, Class<?> returnType) {
        logger.info("RestUtil :: post >>> url : {}, body : {}", url, body.toString());
        if (returnType == null) {
            returnType = Object.class;
        }
        return new RestTemplate(httpRequestFactory).postForObject(url, body, returnType);
    }
}
