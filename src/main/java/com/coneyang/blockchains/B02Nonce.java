package com.coneyang.blockchains;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;

/**
 * 通过nonce参数调整Sha256生成的摘要信息
 * 来满足定义的要求(生成的摘要信息的开头与difficulty一致)
 * @author YangLei
 * @version 1.0.0.1
 * @since 2020/7/10 16:50
 */
public class B02Nonce {
    public static void main(String[] args) {
        String difficulty = "0";
        String data = "0Hello, Cryptos!";
        int nonce = proofOfWork(difficulty, data);
        System.out.println(nonce);

    }

    private static int proofOfWork(String difficulty,String data) {

        int nonce = 0;
        String sha256 = sha256(nonce + data);
        while (true){
            if(StringUtils.startsWithIgnoreCase(sha256,difficulty)){
                System.out.println(sha256);
                return nonce;
            }
            nonce++;
        }
    }

    public static String sha256(String data){
        return DigestUtils.sha256Hex(data);
    }
}
