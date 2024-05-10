package com.codigofacilito.ejemplos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@GetMapping(value ="/")
	public String index(){
		return "index";
	}
	
	@PostMapping(value="/index-post")
	public String indexRequestMapping() {
		return "index";
	}
}
