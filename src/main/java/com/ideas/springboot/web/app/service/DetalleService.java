package com.ideas.springboot.web.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas.springboot.web.app.model.Detalle;
import com.ideas.springboot.web.app.repository.IDetalle;

@Service
public class DetalleService {

	
	@Autowired
	  private IDetalle repo;
	
	
	public Detalle crearDetalle(Detalle conversacion) {
	    return repo.save(conversacion);
	  }
		  
	 /* public Detalle findById(long id) {
	    return repo.findById(id).orElse(null);
	  }*/
		  
	  public Detalle buscarDetalleXid(Long id) {
	    return repo.findById(id).orElse(null);
	  }
 

	  public void modificarDetalle(Detalle request, Long id) {
		  Detalle det = repo.findById(id).get();

		  det.setCodigo(request.getCodigo());
		  det.setRol(request.getRol());
		  det.setMensaje(request.getMensaje());
		  det.setPrompts(request.getPrompts());
		  det.setFecha(request.getFecha());
		  repo.save(det);
	 }
		  
	 public void eliminarDetalleXid(long id) {  
			repo.deleteById(id);
	 }

		  
	 /* public List<Detalle> listarDetalle() {
	    return repo.findAll();
	  }
9*/
	public List<Detalle> listarDetalle() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	  
	  
	  
}
