package com.SoftwareVision.facturas.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.SoftwareVision.facturas.Model.Facturas;
import com.SoftwareVision.facturas.Repository.FacturasRepository;

@RestController 
@RequestMapping("api/v1/facturas") 
public class FacturaController {
	
	@Autowired
	private FacturasRepository FR; //FR es Facturas Repositry
	
	@GetMapping
	public List<Facturas> lista(){
		
		return FR.findAll();
		
	}
	
	
	@PostMapping("/agregar")
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Facturas facturas) {
		
		FR.save(facturas);
		//facturas.setId(45);
		//System.out.println(facturas.toString());
		
	}
	
	@GetMapping("/{id}")
		public Facturas get(@PathVariable("id") long id) {
		
			if(FR.existsById(id)) {
				return FR.getOne(id);
			}else {
				return null;
			}
		
	}
	
	@GetMapping("/borrar/{id}")
	public String delete(@PathVariable long id) {
		
		if(FR.existsById(id)) {
			FR.deleteById(id);
			return "Se elimino el dato de la base";
		}else {
			return "El dato no existe";
		}
	}
	
	
	
}
