package com.github.beans;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qianhao
 * @create 2020/4/18-22:36
 */
public class Msg {
    private int code;
    private String msg;

    private Map<String,Object> extend = new HashMap<String, Object>();

    public static Msg success(){
        Msg msg = new Msg();
        msg.code = 100;
        msg.msg = "操作成功!";
        return msg;
    }

    public static Msg fail(String errormsg){
        Msg msg = new Msg();
        if(StringUtils.isEmpty(errormsg)){
            errormsg = "操作失败!";
        }
        msg.code = 200;
        msg.msg = errormsg;
        return msg;
    }

    public Msg addExtend(String key,Object value){
        this.extend.put(key,value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public Msg setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Msg setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public Msg setExtend(Map<String, Object> extend) {
        this.extend = extend;
        return this;
    }
}
