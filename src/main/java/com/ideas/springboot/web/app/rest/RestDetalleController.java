package com.ideas.springboot.web.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas.springboot.web.app.model.Detalle;
import com.ideas.springboot.web.app.service.DetalleService;

@RestController
@CrossOrigin("*")
@RequestMapping("/detalle")
public class RestDetalleController {

	
	 @Autowired
	 private DetalleService detServicio;
	 

	 //agregar cliente
	 @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	 public Detalle registrarCliente(@Validated @RequestBody Detalle detalle) {
	  return detServicio.crearDetalle(detalle);
	 }
	 
	 
	 
	//////*Buscar Cliente por Cedula*//////
	 @GetMapping("/find/{id}")
	   public Detalle buscarPorid(@PathVariable long id) {
		 
		 System.out.println(id);
	     return detServicio.buscarDetalleXid(id);
	   }
	 
	 //////* Listar Personas *//////
	 @GetMapping(path = "/list", produces = "application/json")
	 public List<Detalle> listarCliente() {
	  return detServicio.listarDetalle();
	 }
	 

	 
	@PutMapping("/mod/{id}")
	 public void updateCli(@RequestBody Detalle request,@PathVariable long id) {
		detServicio.modificarDetalle(request, id);
	 }


		@DeleteMapping("/delete/{id}")
		public void borrarXid(@PathVariable long id) {

			detServicio.eliminarDetalleXid(id);
			
		}
	 
	 
}
