package com.codigofacilito.ejemplos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParametrosController {

	@GetMapping("/parametros")
	public String parametros(@RequestParam (defaultValue = "") String valor, Model model){
		model.addAttribute("titulo","Parametros");
		model.addAttribute("parametro",valor);
		
		return "parametros";
	}
}
