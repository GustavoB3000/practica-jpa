/**
 * 
 */
package com.devpredator.practicajpa.dao;

import java.util.List;

import com.devpredator.practicajpa.entity.Restaurante;

/**
 * Interface que genera el DAO para las transacciones CRUD a la tabla de Restaurante.
 * @author Calistos
 *
 */
public interface RestauranteDAO {

	void guardar(Restaurante restaurante);
	
	void actualizar(Restaurante restaurante);
	
	void eliminar(Long id);
	
	List<Restaurante> consultar();
	
	Restaurante consultarById(Long id);
}
