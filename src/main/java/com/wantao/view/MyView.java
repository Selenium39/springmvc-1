package com.wantao.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

/*
 *@author:wantao
 *@time:Jul 20, 2018 5:56:27 PM
 *@description:
 */
@Component
public class MyView implements View{
    //告知spring容器视图类型
	public String getContentType() {
		// TODO Auto-generated method stub
		return "text/html";
	}
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
      response.getWriter().write("<h1>MyView</h1>");		
	}


}
