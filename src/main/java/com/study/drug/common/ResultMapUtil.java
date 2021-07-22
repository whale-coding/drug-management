package com.study.drug.common;

import java.util.HashMap;

/**
 * 给前端返回的json格式数据
 */
public class ResultMapUtil {

    /**
     * 登录返回结果
     */
    public static HashMap<String,Object> getHashMapLogin(String msg, String code){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("msg",msg);
        resultMap.put("code",code);
        if("1".equals(code)){
            resultMap.put("icon",1);
        }else {
            resultMap.put("icon",3);
        }
        resultMap.put("anim",4);
        return resultMap;
    }
}
