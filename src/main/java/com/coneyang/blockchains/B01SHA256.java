package com.coneyang.blockchains;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * SHA256
 * SHA:哈希函数，数据指纹
 * 256:256bit指纹长度
 * 原理：将数据压缩成摘要，以一定格式处理，形成数据的哈希值
 *
 * @author YangLei
 * @version 1.0.0.1
 * @since 2020/7/10 16:41
 */
public class B01SHA256 {
    public static void main(String[] args) {
        String data = "Hello, Cryptos!";
        String hash256 = DigestUtils.sha256Hex("Hello, Cryptos!");
        System.out.println(hash256);
        int a = 0;
        System.out.println();
    }
}
