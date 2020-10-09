package com.coneyang.blockchains;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sun.javafx.fxml.builder.URLBuilder;
import org.springframework.util.StringUtils;

import javax.mail.internet.MimeMessage;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author YangLei
 * @version 1.0.0.1
 * @since 2020/8/25 10:55
 */
public class TestLambda {


    public static void main(String[] args) {
    }

    private static void doTestLambadMap(){
        Stream<String> stream = Stream.of("a", "b", "c", "d");
        List<String> list = stream.map((value) -> value.toUpperCase())
                .map((value) -> value.concat("123"))
                .collect(Collectors.toList());
        list.stream().forEach(value-> System.out.println(value));
    }

    private static void doTestLambdaReduce(){
      /*  List<String> listStr = Lists.newArrayList("profile=native", "debug=true", "logging=warn");
        listStr.stream()
                .map(value -> {
                    String[] strings = value.split("\\=", 2);
                    return new HashMap<String, String>().put(strings[0], strings[1]);
                })
                .reduce(new HashMap<String, String>(), (m, value) -> {
                    m.putAll(value);
                    return m;
                });*/
        // 按行读取配置文件:
        /*List<String> props = Lists.newArrayList("profile=native", "debug=true", "logging=warn", "interval=500");
        Map<String, String> map = props.stream()
                // 把k=v转换为Map[k]=v:
                .map(kv -> {
                    String[] ss = kv.split("\\=", 2);
                    return new HashMap<String, String>().put(ss[0], ss[1]);
                })
                // 把所有Map聚合到一个Map:
                .reduce(new HashMap<String, String>(), (m, kv) -> {
                    m.putAll(kv);
                    return m;
                });
        // 打印结果:
        map.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });*/
    }

    private static void doTestLambadFilter(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> integerList = integerStream.filter(value -> value % 2 == 0)
                .collect(Collectors.toList());
        integerList.stream().forEach(System.out :: println);
    }

    private static void doMulti() {
        for (int i = 1; i < 10; i++) {
            for (int j = i; j < 10; j++) {
                System.out.println(String.format("{%s}*{%s}={%s}", i,j,i*j));
            }
        }
    }

    private static void doTestLambad() {
        MyLambdaInterface myLambdaInterface = (s) ->
                System.out.println(s+"abc");
        myLambdaInterface.doSomeThing("123");
    }


}
