/********************************************
 * 功能说明: 
 * 模块名称: 
 * 系统名称: 
 * 软件版权: 西安华信智慧数字科技有限公司
 * 系统版本: 1.0.0
 * 开发人员: zhangfb
 * 开发时间: 2020/7/10 16:50
 * 审核人员: 
 * 相关文档: 
 * 修改记录: 修改日期 修改人员 修改说明
 *********************************************/
package com.coneyang.blockchains;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;

/**
 * @author YangLei
 * @version 1.0.0.1
 * @since 2020/7/10 16:50
 */
public class B02Nonce {
    public static void main(String[] args) {
        String difficulty = "00";
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
