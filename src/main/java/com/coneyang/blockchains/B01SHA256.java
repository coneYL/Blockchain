package com.coneyang.blockchains;

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
        int maxWidth = 1600;
        int maxHight = 900;
        while (findY(maxWidth)){
            maxWidth--;
        }
        System.out.println("maxWidth = "+maxWidth);
        System.out.println("maxHight = "+9 * maxWidth / 16);

        while (findX(maxHight)){
            maxHight--;
        }
        System.out.println("maxWidth = "+16 * maxHight / 9);
        System.out.println("maxHight = "+maxHight);

    }
    public static boolean findY(int x){
        return 9 * x % 16 != 0 ;
    }

    public static boolean findX(int y){
        return 16 * y % 9 != 0;
    }
}
