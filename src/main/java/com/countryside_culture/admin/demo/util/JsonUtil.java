package com.countryside_culture.admin.demo.util;

import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class JsonUtil {
	public static void ajaxReturn(HttpServletResponse response,Object object) {
		String objJson=JSON.toJSONString(object);
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Cach-Control", "no-cache");
		response.setDateHeader("Expirse", 0);
		ServletOutputStream pw=null;
		try {
			pw=response.getOutputStream();
			pw.print(objJson);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public static String ajaxReturn(Object object) {
		String objJson=JSON.toJSONString(object);
		return objJson;
	}
}
