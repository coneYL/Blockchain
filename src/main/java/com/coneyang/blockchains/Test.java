package com.coneyang.blockchains;

import com.google.common.collect.Lists;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author YangLei
 * @version 1.0.0.1
 * @since 2020/7/15 17:03
 */
public class Test {
    public static void main(String[] args) {
        List<String> stringList = Lists.newArrayList("a", "b", "c");
        for (int i = 0; i < stringList.size(); i++) {
            if("a".equals(stringList.get(i))){
                stringList.remove("a");
            }
        }

        System.out.println(Arrays.toString(stringList.toArray()));
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
