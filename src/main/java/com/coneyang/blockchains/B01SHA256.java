/********************************************
 * 功能说明: 
 * 模块名称: 
 * 系统名称: 
 * 软件版权: 西安华信智慧数字科技有限公司
 * 系统版本: 1.0.0
 * 开发人员: zhangfb
 * 开发时间: 2020/7/10 16:41
 * 审核人员: 
 * 相关文档: 
 * 修改记录: 修改日期 修改人员 修改说明
 *********************************************/
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
    }
}
