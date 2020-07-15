/********************************************
 * 功能说明: 
 * 模块名称: 
 * 系统名称: 
 * 软件版权: 西安华信智慧数字科技有限公司
 * 系统版本: 1.0.0
 * 开发人员: zhangfb
 * 开发时间: 2020/7/15 17:15
 * 审核人员: 
 * 相关文档: 
 * 修改记录: 修改日期 修改人员 修改说明
 *********************************************/
package com.coneyang.blockchains;

import com.google.common.collect.Lists;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;

/**
 * 将每块区块信息，连接起来，使之形成链
 * 且链上的数据都可以追溯、校验
 * @author YangLei
 * @version 1.0.0.1
 * @since 2020/7/15 17:15
 */
public class B03Link {

    public static void main(String[] args) {
        B03Link.Block firstBlock = new B03Link.Block("Hello, Cryptos!", "0000000000000000000000000000000000000000000000000000000000000000", 24287, "0000");
        String firstBlockHash = sha256(firstBlock.toString());
        printBlock(firstBlock,firstBlockHash);

        B03Link.Block secondBlock = new B03Link.Block("Hello, Cryptos! - Hello, Cryptos!", firstBlockHash, 191453, "0000");
        String secondBlockHash = sha256(secondBlock.toString());
        printBlock(secondBlock,secondBlockHash);

        B03Link.Block threeBlock = new B03Link.Block("Your Name Here", secondBlockHash, 109213, "0000");
        String threeBlockHash = sha256(threeBlock.toString());
        printBlock(threeBlock,threeBlockHash);

        B03Link.Block fourBlock = new B03Link.Block("Data Data Data Data", threeBlockHash, 129257, "0000");
        String fourBlockHash = sha256(fourBlock.toString());
        printBlock(fourBlock,fourBlockHash);

        List<B03Link.Block> blockChain = Lists.newArrayList(firstBlock, secondBlock, threeBlock, fourBlock);
        System.out.println(blockChain.size());
    }

    public static void printBlock(Block block,String hash){
        System.out.println("########");
        System.out.println("data        = "+block.getData());
        System.out.println("hash        = "+hash);
        System.out.println("nonce       = "+block.getNonce());
        System.out.println("prev        = "+block.getPrev());
        System.out.println("difficulty  = "+block.getDifficulty());
        System.out.println("########");
        System.out.println("");
    }

    public static String sha256(String content){
        return DigestUtils.sha256Hex(content);
    }

    static class Block{

        public Block() {
        }

        public Block(String data, String prev, int nonce, String difficulty) {
            this.data = data;
            this.prev = prev;
            this.nonce = nonce;
            this.difficulty = difficulty;
        }

        /**
         * 数据
         */
        private String data;

        /**
         * 前面区块摘要
         */
        private String prev;

        /**
         * 随机参数
         */
        private int nonce;

        /**
         * 校验条件
         */
        private String difficulty;

        public String getData() {
            return data;
        }

        public String getPrev() {
            return prev;
        }

        public int getNonce() {
            return nonce;
        }

        public String getDifficulty() {
            return difficulty;
        }

        @Override
        public String toString() {
            return nonce + prev + data;
        }
    }

}
