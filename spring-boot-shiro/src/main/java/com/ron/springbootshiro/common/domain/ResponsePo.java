package com.ron.springbootshiro.common.domain;

import java.util.HashMap;

public class ResponsePo extends HashMap<String,Object> {

    // 成功
    private static final Integer SUCCESS = 0;
    // 警告
    private static final Integer WARN = 1;
    // 异常 失败
    private static final Integer ERROR = 500;

    public ResponsePo() {
        put("code", SUCCESS);
        put("msg", "操作成功");
    }

    public static ResponsePo success(Object msg){
        ResponsePo responsePo = new ResponsePo();
        responsePo.put("code",SUCCESS);
        responsePo.put("msg",msg);
        return responsePo;
    }


    public static ResponsePo warn(Object msg){
        ResponsePo responsePo = new ResponsePo();
        responsePo.put("code",WARN);
        responsePo.put("msg",msg);
        return responsePo;
    }

    public static ResponsePo error(Object msg){
        ResponsePo responsePo = new ResponsePo();
        responsePo.put("code",ERROR);
        responsePo.put("msg",msg);
        return responsePo;
    }


}
