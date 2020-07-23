package com.bonato.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	/*
	@GetMapping("/")
	public String home() {
		//redirigir al home el redirect elimina los elemenos de la request enviamos previamente
		return "redirect:/app/home";
	}
	
	
	@GetMapping("/")
	public String home() {
		//redirigir al home
		return "redirect:https://www.google.com.ar";
	}
	*/
	
	@GetMapping("/")
	public String home() {
		//redirigir al home no 
		// no se peude hacer un forward hacia una ruta externa como google
		return "forward:/app/home";
	}
	


}
