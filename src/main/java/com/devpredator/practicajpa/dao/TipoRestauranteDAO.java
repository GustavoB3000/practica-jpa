/**
 * 
 */
package com.devpredator.practicajpa.dao;

import java.util.List;

import com.devpredator.practicajpa.entity.TipoRestaurante;

/**
 * Interface que genera el DAO para las transacciones CRUD a la tabla de TipoRestaurante.
 * @author Calistos
 */
public interface TipoRestauranteDAO {

	void guardar(TipoRestaurante restaurante);

	void actualizar(TipoRestaurante restaurante);

	void eliminar(Long id);

	List<TipoRestaurante> consultar();

	TipoRestaurante consultarById(Long id);
}
