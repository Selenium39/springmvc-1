package com.wantao.controller;

import java.util.Map;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wantao.bean.User;

/*
 *@author:wantao
 *@time:Jul 20, 2018 1:31:20 PM
 *@description:
 */
@Controller
public class HelloController {
	private static final Logger logger = Logger.getLogger("HelloController.class");

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}

	// 必须带有参数访问url
	@RequestMapping(value = "/hello", method = RequestMethod.GET, params = { "name" })
	public String hello1() {
		return "hello";
	}

	// 使用Ant风格的url
	// @RequestMapping(value="/hello*")//hello后可带任意字符
	// public String hello2() {
	// return "hello";
	// }
	@RequestMapping(value = "/hello?") // hello后可带一个任意字符
	public String hello3() {
		return "hello";
	}

	@RequestMapping(value = "**/hello") // 匹配多层路径
	public String hello4() {
		return "hello";
	}

	// 带有占位符的url
	@RequestMapping(value = "/hello/{id}")
	public String hello5(@PathVariable("id") Integer id) {
		logger.info("id为:" + id);
		return "hello";
	}

	// 使用delete请求
	@RequestMapping(value = "/deleteTest/{id}", method = RequestMethod.DELETE)
	public String hello6(@PathVariable("id") Integer id) {
		logger.info("delte请求成功执行");
		return "hello";
	}

	// 获取请求上下文

	// 通过@RequestParam
	@RequestMapping(value = "/testRequestParam", method = RequestMethod.POST)
	public String hello7(@RequestParam("username") String a, String id) {// 当形参与前端的值同名是可以不使用@RequestParam
		logger.info(a);
		logger.info(id);
		return "hello";
	}

	// 通过pojo
	@RequestMapping(value = "/testPojo", method = RequestMethod.POST)
	public String hello8(User user) {
		logger.info(user.toString());
		return "hello";
	}
	
	//处理模型数据
	//使用ModelAndView
	@RequestMapping(value="/testModelAndView")
	public ModelAndView hello9() {
		ModelAndView mv=new ModelAndView();//模型的值存在Request作用域
		mv.setViewName("hello");
		mv.addObject("name","万涛");
		return mv;
	}
	
	// @ModelAttribute
	   @ModelAttribute
	   public void beforeHello(Map map) {
		   User user=new User();
		   user.setName("万涛");
		   user.setAge(20);
		   map.put("user",user);
		   
	   }
	
		@RequestMapping(value = "/testModelAttribute", method = RequestMethod.POST)
		public String hello10(@ModelAttribute("user")User user) {
			logger.info(user.toString());
			return "hello";
		}

}
