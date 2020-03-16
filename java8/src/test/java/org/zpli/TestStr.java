package org.zpli;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/13 16:52
 */
public class TestStr {

    @Test
    public void ss(){
        String str = "{\"code\":\"0\"}";
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println(jsonObject);
        if(str.contains("\"code\":0")){
            System.out.println("enter...");
            return;
        }
        System.out.println(" not enter...");
    }
}
