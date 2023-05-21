package com.ideas.springboot.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ideas.springboot.web.app.model.Conversacion;


@Repository
public interface IConversacion  extends JpaRepository<Conversacion, Long> {

	/*@Query("SELECT c FROM Cliente c WHERE c.cedula = ?1")
	public Detalle findByCedula(String cedula);
*/
}
