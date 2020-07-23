package com.bonato.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {
	
	@GetMapping("/")
	public String index() {
		return "params/enviar";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(name="texto", required = false, defaultValue = "Vamo boke") String texto, Model model) {
		model.addAttribute("resultado","el parametro enviado es "+ texto);
		return "params/ver";
	}
	
	@GetMapping("/mix")
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		model.addAttribute("resultado","el saludo es: " + saludo +" y el numero es "+numero);
		return "params/ver";
	}

	@GetMapping("/mix-request")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		try {
			//Parseo a integer ya que el getParameter me retorna un valor de tipo String
			numero = Integer.parseInt(request.getParameter("numero"));
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("resultado","el saludo es: " + saludo +" y el numero es "+numero);
		return "params/ver";
	}

}
