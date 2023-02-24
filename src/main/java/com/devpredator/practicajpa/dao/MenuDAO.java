/**
 * 
 */
package com.devpredator.practicajpa.dao;

import java.util.List;

import com.devpredator.practicajpa.entity.Menu;

/**
 * Interface que genera el DAO para las transacciones CRUD a la tabla de Menu.
 * @author Calistos
 *
 */
public interface MenuDAO {

	void guardar(Menu menu);
	
	void actualizar(Menu menu);
	
	void eliminar(Long id);
	
	List<Menu> consultar();
	
	Menu consultarById(Long id);
	
}
