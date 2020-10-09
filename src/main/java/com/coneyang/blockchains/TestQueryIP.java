package com.coneyang.blockchains;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * @author YangLei
 * @version 1.0.0.1
 * @since 2020/9/28 14:17
 */
public class TestQueryIP {

    static String URL = "http://ip-api.com/json/223.104.176.140?lang=zh-CN";

    public static void main(String[] args) {
        RestTemplate restTemplate = TestQueryIP.getInstance("utf-8");
        StringBuilder result = new StringBuilder();
        result.append(restTemplate.getForEntity(URL, String.class).getBody());
        System.out.println(result);
        Map map =  JSONObject.parseObject(result.toString());
        System.out.println(map.get("city"));
    }

    public static RestTemplate getInstance(String charset) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(1,new StringHttpMessageConverter(Charset.forName(charset)));
        return restTemplate;
    }
}
