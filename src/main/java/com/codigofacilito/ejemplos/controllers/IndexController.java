package com.codigofacilito.ejemplos.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class IndexController {

	@GetMapping(value ="/")
	public String index(Model model){
		model.addAttribute("titulo","Soy el titulo");
		model.addAttribute("saludo","Soy el saludo");
		model.addAttribute("show",false);
		List<String> series = List.of("Dexter","Spiderman", "Vikings");
		model.addAttribute("series",series);
		return "index";
	}
	
	@PostMapping(value="/index-post")
	public String indexRequestMapping() {
		return "index";
	}
}
