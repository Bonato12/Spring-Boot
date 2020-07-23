package com.bonato.springboot.webfacturas.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bonato.springboot.webfacturas.app.models.domain.ItemFactura;
import com.bonato.springboot.webfacturas.app.models.domain.Producto;

@Configuration
public class AppConfig {
	
	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems(){
		Producto producto1 = new Producto("CPU Ryzen 7", 12000);
		Producto producto2 = new Producto("Notebook Asus", 25000);
		
		ItemFactura linea1 = new ItemFactura(producto1, 2);
		ItemFactura linea2 = new ItemFactura(producto2, 4);	
		// Arrays.asList seria lo mismo que definir un arrayList, y luego hacer el .add
		
		return Arrays.asList(linea1,linea2);
	}

}