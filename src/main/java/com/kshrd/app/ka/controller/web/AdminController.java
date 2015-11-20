package com.kshrd.app.ka.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping(value={"/user","/" })
	public String adminPage(){
		return "admin/user";
	}
	
	@RequestMapping(value={"/api" })
	public String webServiceApi(){
		return "admin/webservice-api";
	}

	
}
