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

import com.ideas.springboot.web.app.model.Conversacion;
import com.ideas.springboot.web.app.service.ConversacionService;

@RestController
@CrossOrigin("*")
@RequestMapping("/conversacion")
public class RestConversacionController {

	@Autowired
	private ConversacionService conServicio;

	// agregar cliente
	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	public Conversacion registrarCliente(@Validated @RequestBody Conversacion conversacion) {
		return conServicio.crearConversacion(conversacion);
	}

	////// *Buscar Cliente por Cedula*//////
	@GetMapping("/find/{id}")
	public Conversacion buscarPorCedula(@PathVariable long id) {
		return conServicio.findById(id);
	}

	////// * Listar Personas *//////
	@GetMapping(path = "/list", produces = "application/json")
	public List<Conversacion> listarCliente() {
		return conServicio.listarConversaciones();
	}

	@GetMapping("/findByCedula/{cedula}")
	public Conversacion buscarPorId(@PathVariable long id) {
		return conServicio.buscarConversacionXid(id);
	}

	@PutMapping("/mod/{id}")
	public Conversacion updateCli(@RequestBody Conversacion request, @PathVariable long id) {
	   return	conServicio.modificarConversacion(request, id);
		
		
	}

	@DeleteMapping("/delete/{id}")
	public void borrarXid(@PathVariable long id) {

		conServicio.eliminarConversacionXid(id);

	}
}
