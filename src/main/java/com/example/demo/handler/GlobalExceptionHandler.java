package com.example.demo.handler;

import com.example.demo.model.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	public static final String DEFAULT_ERROR_VIEW = "error";

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception{
		ModelAndView view = new ModelAndView();
		view.addObject("exception", e);
		view.addObject("url", req.getRequestURL());
		view.setViewName(DEFAULT_ERROR_VIEW);
		return view;
	}

	@ExceptionHandler(value = MyException.class)
	@ResponseBody
	public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception{
		ErrorInfo<String> errorInfo = new ErrorInfo<>();
		errorInfo.setMessage(e.getMessage());
		errorInfo.setCode(ErrorInfo.ERROR);
		errorInfo.setData("Some Data");
		errorInfo.setUrl(req.getRequestURL().toString());
		return errorInfo;
	}
}
