package com.bonato.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bonato.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	//inyecion de dependencia conya voy  valores con @Value
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	@GetMapping("/home")
	public ModelAndView index(ModelAndView mv) {
		mv.addObject("titulo",textoIndex);
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Sebastian");
		usuario.setApellido("Bonato");
		usuario.setEmail("sebabonato12@gmail.com");
		model.addAttribute("titulo",textoPerfil);
		model.addAttribute("usuario", usuario);
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo",textoListar);
		return "listar";
		
	}
	
	//Atributos del modelo/ con hacerlo referencia en el html ya lo llama
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		//Se utiliza cuando un mismo dato se requieren pasar en distintos handler/acciones 
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario1 = new Usuario();
		usuario1.setNombre("Sebastian");
		usuario1.setApellido("Bonato");
		usuario1.setEmail("sebabonato12@gmail.com");
		
		Usuario usuario2 = new Usuario();
		usuario2.setNombre("Juan Roman");
		usuario2.setApellido("Riquelme");
		usuario2.setEmail("riquelme10@gmail.com");
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		//Otra forma de crear un array, pasandoles objetos separadas por ","
		//List<Usuario> usuarios = Arrays.asList(usuario1,usuario2);
		
		return usuarios;
		
		
	}
	

}
