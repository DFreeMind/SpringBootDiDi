package com.example.demo.controller;

import com.example.demo.handler.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/json")
	public String json() throws MyException{
		throw new MyException("发生错误 2");
	}

	@RequestMapping("/hello")
	public String hello() throws Exception{
		throw new Exception("发生错误");
	}
}
