package com.bonato.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("variables")
public class VariablesRutaController {
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo","Enviar parametros de la ruta @PathVariable");
		return "variables/index";
	}
	
	// el nombre del parametro (texto) en getMapping debe ser el mismo de la funcion
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String texto, Model model) {
		model.addAttribute("titulo", "El textooo enviado es +"+texto);
		return "variables/ver";
	}
	
	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable String texto,@PathVariable Integer numero, Model model) {
		model.addAttribute("titulo", "El textoaaa enviado es +"+texto+ "y el numero es "+ numero);
		return "variables/ver";
	}


}
