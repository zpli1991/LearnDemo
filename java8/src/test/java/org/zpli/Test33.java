package org.zpli;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/17 16:29
 */
public class Test33 {

    @Test
    public void t1(){
        String str = "{\"BODY\":{\"EryptFlg\":\"\",\"RetCd\":-1,\"CmprsFlg\":0,\"Data\":\"\",\"ErrInfo\":\"[1202] System sneak off.\",\"CrnTm\":1584239971699}}";
        // {"BODY":{"EryptFlg":"","RetCd":-1,"CmprsFlg":0,"Data":"","ErrInfo":"[{"a":"11","b":"22"},{"a":"33","b":"44"}]","CrnTm":1584239971699}}
        String str2 = "{\"code\":0,\"data\":{\"userInfoList\":[{\"UAId\":130382,\"iconId\":261021,\"roleSetList\":[{\"roleSetId\":-1,\"roleSetName\":\"管理员\",\"roleList\":[{\"roleId\":-1,\"roleName\":\"主管理员\"}]}],\"credentials\":{\"Id\":\"422129198211302514\",\"type\":110},\"uName\":\"苏永彬\",\"userKind\":1,\"uPhone\":\"13760395150\",\"mstpId\":\"4355365273622\",\"sex\":1,\"isActive\":1}],\"cpyList\":[{\"cpyId\":2017233832,\"cpyName\":\"深圳兆日国际旅行社有限责任公司\",\"cpyPhone\":\"13760395150\",\"cpyUNum\":80,\"crtName\":\"苏永彬\",\"crtPhone\":\"13760395150\",\"isFullAddr\":0,\"logoUrl\":\"RjRfOGM5NDUyM2RhYmJhNGRiYWE4Zjk5NjA0NmE1ODk2ZjBfNDM1NTA5NjgzODE0NA\",\"contactList\":[{\"contactName\":\"苏永彬\",\"contactUaId\":\"130382\",\"contactPhone\":\"13760395150\",\"directChat\":2}],\"companyNo\":\"E20190821000252\",\"industryType\":1086190,\"crtUAId\":130382,\"cpyType\":111520,\"status\":3}]},\"ecode\":\"0\",\"time\":1584240181}";
        JSONObject jsonObject = new JSONObject(str2);
        JSONObject j2 = jsonObject.getJSONObject("data");
        JSONObject j3 = new JSONObject();
        j3.put("BODY",j2);
        JSONObject result =  addStructForJsonArray(j3);
        System.out.println(result);
    }

    private static JSONObject addStructForJsonArray(JSONObject json) {
        JSONObject jsonWithStruct = new JSONObject();
        JSONObject jsonWithoutBody = json;
        if (json.keySet().contains("BODY")){
            jsonWithoutBody = json.getJSONObject("BODY");
        }
        for (String key :jsonWithoutBody.keySet()){
            String item = String.valueOf(jsonWithoutBody.get(key));
            System.out.println(item);
            //解决空字符串导致空指针
            if (StringUtils.isEmpty(item)){
                jsonWithStruct.put(key, "");
                continue;
            }

            Object itemInstance = new JSONTokener(item).nextValue();

            if (itemInstance instanceof JSONArray){
                JSONArray arrayWithoutStruct;
                try {
                    arrayWithoutStruct = jsonWithoutBody.getJSONArray(key);
                }catch (Exception e){
                    System.out.println(String.format("通过[%s]获取JSONArray异常，以String类型处理数据[%s]",key,item));
                    jsonWithStruct.put(key, item);
                    continue;
                }

                JSONArray arrayWithStruct = new JSONArray();
                for (int index = 0; index < arrayWithoutStruct.length(); index++){
                    JSONObject struct = new JSONObject();
                    struct.put("struct", arrayWithoutStruct.getJSONObject(index));
                    arrayWithStruct.put(struct);
                }
                jsonWithStruct.put(key, arrayWithStruct);

            }else {
                jsonWithStruct.put(key, item);
            }
        }

        JSONObject result = jsonWithStruct;
        if (json.keySet().contains("BODY")){
            result = new JSONObject();
            result.put("BODY", jsonWithStruct);
        }
        System.out.println("jsonWithStruct " + result.toString());
        return result;
    }
}
