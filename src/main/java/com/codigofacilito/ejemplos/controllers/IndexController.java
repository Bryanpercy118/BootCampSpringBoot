package com.codigofacilito.ejemplos.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class IndexController {

	@GetMapping(value ="/")
	public String index(Model model){
		model.addAttribute("titulo","Soy el titulo");
		model.addAttribute("saludo","Soy el saludo");
		model.addAttribute("show",false);
		//List<String> series = List.of("Dexter","Spiderman", "Vikings");
		//model.addAttribute("series",series);
		return "index";
	}
	
	@GetMapping(value="/index-mv")
	public ModelAndView indexMv(ModelAndView mv){
		mv.addObject("titulo","Titulo de mv");
		mv.addObject("saludo","Saludo de mv");
		mv.addObject("show",true);
		//List<String> series = List.of("Dexter","Spiderman", "Vikings");
		//mv.addObject("series",series);
		mv.setViewName("index");
		return mv;
	}
	
	@ModelAttribute("series")
	public List<String> getSeries(){
		
		return List.of("Dexter", "Game of Thrones", "Vikings");
	}
	
	
	@PostMapping(value="/index-post")
	public String indexRequestMapping() {
		return "index";
	}
}
