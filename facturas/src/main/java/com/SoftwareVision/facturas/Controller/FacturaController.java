package com.softwarevision.facturas.controller;

import java.util.List;

import com.softwarevision.facturas.model.Facturas;
import com.softwarevision.facturas.repository.FacturasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("api/v1/facturas") 
public class FacturaController {
	
	@Autowired
	private FacturasRepository FR; //FR es Facturas Repositry
	
	@GetMapping
	public List<Facturas> lista(){
		
		return FR.findAll();
		
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
	
	@PostMapping("/agregar")
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Facturas facturas) {
		
		FR.save(facturas);
		//facturas.setId(45);
		//System.out.println(facturas.toString());
		
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Facturas> update(@PathVariable("id") long id, @RequestBody Facturas facturas) {
		
		return FR.findById(id)
			.map(facturaUpd -> {
				facturaUpd.setCantidad(facturas.getCantidad());
				facturaUpd.setDescripcionDelArticulo(facturas.getDescripcionDelArticulo());
				facturaUpd.setMarcaDelArticulo(facturas.getMarcaDelArticulo());
				facturaUpd.setPrecioDeCompra(facturas.getPrecioDeCompra());
				facturaUpd.setPrecioDeVenta(facturas.getPrecioDeVenta());
				Facturas updated = FR.save(facturaUpd);
				return ResponseEntity.ok().body(updated);
				}).orElse(ResponseEntity.notFound().build());
		
	}
	
	
}
