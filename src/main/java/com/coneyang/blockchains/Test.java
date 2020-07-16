/********************************************
 * 功能说明: 
 * 模块名称: 
 * 系统名称: 
 * 软件版权: 西安华信智慧数字科技有限公司
 * 系统版本: 1.0.0
 * 开发人员: zhangfb
 * 开发时间: 2020/7/15 17:03
 * 审核人员: 
 * 相关文档: 
 * 修改记录: 修改日期 修改人员 修改说明
 *********************************************/
package com.coneyang.blockchains;

import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @author YangLei
 * @version 1.0.0.1
 * @since 2020/7/15 17:03
 */
public class Test {
    public static void main(String[] args) {
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
