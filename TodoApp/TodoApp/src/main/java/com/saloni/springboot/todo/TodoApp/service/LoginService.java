package com.saloni.springboot.todo.TodoApp.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean authenticate(String username,String password)
	{
		boolean isValidUserName=username.equalsIgnoreCase("Saloni");
		boolean isValidPassword=password.equalsIgnoreCase("xyz");
		return isValidUserName && isValidPassword;
	}

}
