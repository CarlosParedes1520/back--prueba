package com.ideas.springboot.web.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas.springboot.web.app.model.Conversacion;
import com.ideas.springboot.web.app.repository.IConversacion;

import jakarta.transaction.Transactional;

@Service
public class ConversacionService {

	@Autowired
	private IConversacion repo;

	public Conversacion crearConversacion(Conversacion conversacion) {
		return repo.save(conversacion);
	}

	public Conversacion findById(long id) {
		return repo.findById(id).orElse(null);
	}

	public Conversacion buscarConversacionXid(long id) {
		return repo.findById(id).orElse(null);
	}

	/*public void modificarConversacion(Conversacion request, long id) {
		Conversacion con = repo.findById(id).get();

		con.setSistema(request.getSistema());
		con.setFecha(request.getFecha());

		repo.save(con);
	}*/

	public void eliminarConversacionXid(long id) {
		repo.deleteById(id);
	}

	
	public List<Conversacion> listarConversaciones() {
		return repo.findAll();
	}

	public Conversacion modificarConversacion(Conversacion request, long id) {
		Conversacion con = repo.findById(id).get();

		con.setSistema(request.getSistema());
		con.setFecha(request.getFecha());

		return repo.save(con);
		
	}

}
