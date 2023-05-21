package com.ideas.springboot.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ideas.springboot.web.app.model.Detalle;


@Repository
public interface IDetalle extends JpaRepository<Detalle, Long> {

	/*@Query("SELECT c FROM Cliente c WHERE c.cedula = ?1")
	public Detalle findByCedula(String cedula);
*/
}