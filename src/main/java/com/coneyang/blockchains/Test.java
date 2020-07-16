package com.coneyang.blockchains;

import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author YangLei
 * @version 1.0.0.1
 * @since 2020/7/15 17:03
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }

    private static void doWhile() {
        for (int i =1;i<=7;i++){
            System.out.println(make(i,"0"));
        }
    }

    public static String make(int length,String unit){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(unit);
        }
        return stringBuilder.toString();
    }
}
