package com.coneyang.blockchains;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * 通过加入时间，使区块链的时间只能向前，且可校验
 * @author YangLei
 * @version 1.0.0.1
 * @since 2020/7/16 9:47
 */
public class B04TimeLine {
    private static class Block{
        public Block() {
        }

        public Block(String prev, String data, int nonce, Long time, String difficulty) {
            this.prev = prev;
            this.data = data;
            this.nonce = nonce;
            this.time = time;
            this.difficulty = difficulty;
        }

        private String prev;
        private String data;
        private int nonce;
        private Long time;
        private String difficulty;

        @Override
        public String toString() {
            //细节，nonce+time需要字符串拼接，不能数值相加
            return this.nonce +""+ this.time + this.difficulty + prev + data;
        }

        public String getPrev() {
            return prev;
        }

        public String getData() {
            return data;
        }

        public int getNonce() {
            return nonce;
        }

        public Long getTime() {
            return time;
        }

        public String getDifficulty() {
            return difficulty;
        }
    }

    public static String sha256(String content){
        return DigestUtils.sha256Hex(content);
    }

    private static void printInfo(B04TimeLine.Block block){
        System.out.println("#############");
        System.out.println("data " + block.data);
        System.out.println("difficulty " + block.difficulty);
        System.out.println("nonce " + block.nonce);
        System.out.println("prev " + block.prev);
        System.out.println("time " + block.time);
        System.out.println("#############");
        System.out.println("");

    }

    public static void main(String[] args) {
        B04TimeLine.Block first = new Block("0000000000000000000000000000000000000000000000000000000000000000","Hello, Cryptos!",215028,1521292321L,"0000");
        String firstHash = sha256(first.toString());
        System.out.println(firstHash);
        printInfo(first);
    }
}
