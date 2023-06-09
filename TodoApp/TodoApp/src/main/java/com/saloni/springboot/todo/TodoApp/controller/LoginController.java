package com.saloni.springboot.todo.TodoApp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.saloni.springboot.todo.TodoApp.service.LoginService;


@Controller
@SessionAttributes("name")
public class LoginController {
	
	private LoginService authenticationService;
	public LoginController(LoginService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String gotoLoginPage()
	{
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name,@RequestParam String password,ModelMap model)
	{
		if(authenticationService.authenticate(name, password))
		{
		model.put("name", name);
		//model.put("password",password);
		return "welcome";
		}
		
		model.put("errorMessage", "Invalid Credentials! Please try again");
		return "login";
	}

	
}