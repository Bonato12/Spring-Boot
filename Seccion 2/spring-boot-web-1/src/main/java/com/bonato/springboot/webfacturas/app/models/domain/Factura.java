package com.bonato.springboot.webfacturas.app.models.domain;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
/*
El alcance del componente va a durar hasta que se recargue la pagina, 
pero por defecto usamos singleton que hasta cuando se destruye el servidor
*/
//@RequestScope
public class Factura {
	
	@Value("${factura.descripcion}")
	private String descripcion;
	// Inyectamos el cliente, principio hollywood(No nos llames, nosotros te llamamos)
	@Autowired
	private Cliente cliente;
	@Autowired
	//Con el Qualifier llamamos a un bean por su nombre esto es si tenemos mas de un bean del mismo tipo "itemsFactura"
	@Qualifier("itemsFactura")
	private List<ItemFactura> items;
	public String getDescripcion() {
		return descripcion;
	}
	
	//Metodo que se ejecuta al inicializar, sirve para inicializar una tarea
	@PostConstruct
	public void inicializar() {
		cliente.setNombre(cliente.getNombre().concat(" ").concat("Ivan"));
		descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
	}
	
	@PreDestroy
	public void destruir() {
		System.out.println("Factura Destruida");
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItemFactura> getItems() {
		return items;
	}
	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}
	
	

}
