package com.coneyang.blockchains;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;

/**
 * 难度系数，
 * 通过difficulty参数，来提高sha256的计算次数，控制计算结果的计算时长
 *
 * @author YangLei
 * @version 1.0.0.1
 * @since 2020/7/16 10:30
 */
public class B05Difficulty {
    private static class Block {
        private String data;
        private String prev;
        private Long time;
        private String difficulty;
        private int nonce;

        public Block(String data, String prev, String difficulty) {
            this.data = data;
            this.prev = prev;
            this.time = System.currentTimeMillis();
            this.difficulty = difficulty;
            this.nonce = computNonce(this.time);
        }

        private int computNonce(Long time) {
            int nonce = 0;
            while (true){
                String hash = sha256(this.nonce + this.data);
                if(StringUtils.startsWithIgnoreCase(hash,this.difficulty)){
                    return nonce;
                }
                nonce++;
            }
        }

        private String sha256(String content) {
            return DigestUtils.sha256Hex(content);
        }

        private void printBlock(){
            System.out.println("#############");
            System.out.println("data " + this.data);
            System.out.println("difficulty " + this.difficulty);
            System.out.println("nonce " + this.nonce);
            System.out.println("prev " + this.prev);
            System.out.println("time " + this.time);
            System.out.println("#############");
            System.out.println("");
        }

    }

    public static String makeDifficulty(){
        return makeString(1, "0");
    }
    private static String makeString(int length,String unit){
        if(length<=0){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(unit);
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        String difficulty = makeDifficulty();
        B05Difficulty.Block first = new Block("Hello, Cryptos!","0000000000000000000000000000000000000000000000000000000000000000",difficulty);
        first.printBlock();
    }
}
