package com.countryside_culture.admin.demo.util;

import com.countryside_culture.admin.demo.entity.Result;

public class ResultUtil {

    public static Result success(Integer code,String msg,Object object) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        result.setData(object);
        return result;
    }

    public static Result success(String msg,Object object) {
        Result result = new Result();
        result.setCode(20000);
        result.setMessage(msg);
        result.setData(object);
        return result;
    }

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(20000);
        result.setMessage("success");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }
}