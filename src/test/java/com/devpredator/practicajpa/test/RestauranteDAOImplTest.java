/**
 * 
 */
package com.devpredator.practicajpa.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.devpredator.practicajpa.dao.RestauranteDAO;
import com.devpredator.practicajpa.dao.impl.RestauranteDAOImpl;
import com.devpredator.practicajpa.entity.Menu;
import com.devpredator.practicajpa.entity.Restaurante;
import com.devpredator.practicajpa.entity.TipoRestaurante;

/**
 * @author Calistos
 *
 */
class RestauranteDAOImplTest {

	private RestauranteDAO restauranteDAO = new RestauranteDAOImpl();
	
	/**
	 * Test method for {@link com.devpredator.practicajpa.dao.impl.RestauranteDAOImpl#guardar(com.devpredator.practicajpa.entity.Restaurante)}.
	 */
	@Test
	void testGuardar() {
		//Creamos los objetos necesarios para poder guardar un restaurante:
		
		//TipoRestaurante:
		TipoRestaurante tr = new TipoRestaurante();
		tr.setDescripcion("Holandes");
		tr.setFechaCreacion(LocalDateTime.now());
		tr.setEstatus(true);
		
		//Menu:
		Menu menu = new Menu();
		menu.setClave("HOL123");
		menu.setDescripcion("Menu Holandes");
		menu.setFechaCreacion(LocalDateTime.now());
		menu.setEstatus(true);
		
		//Finalmente agregamos los dos objetos anteriores creados a un objeto del tipo Restaurante:
		Restaurante res = new Restaurante();
		res.setNombre("Restaurante Holandes");
		res.setImagen("Una imagen");
		res.setSlogan("Un slogan");
		res.setTipoRestaurante(tr);
		res.setFechaCreacion(LocalDateTime.now());
		res.setEstatus(true);
		res.setMenu(menu);
		
		//Ahora probamos mediante el objeto restauranteDAO su metodo guardar:
		this.restauranteDAO.guardar(res);
	}

	/**
	 * Test method for {@link com.devpredator.practicajpa.dao.impl.RestauranteDAOImpl#actualizar(com.devpredator.practicajpa.entity.Restaurante)}.
	 */
	@Test
	void testActualizar() {
		Restaurante restauranteConsultado = this.restauranteDAO.consultarById(14L);
		
		//Modificacion del menu del Restaurante:
		restauranteConsultado.getMenu().setClave("HOL2023");
		restauranteConsultado.getMenu().setDescripcion("Menu Holandes 2023");
		restauranteConsultado.getMenu().setFechaModificacion(LocalDateTime.now());
		
		//Modificacion del tipoDeRestaurante del Restaurante:
		restauranteConsultado.getTipoRestaurante().setDescripcion("Holandes sur");
		restauranteConsultado.getTipoRestaurante().setFechaModificacion(LocalDateTime.now());
		
		//Ahora ejecutamos el metodo de actualizar mediante el objeto restauranteDAO:
		this.restauranteDAO.actualizar(restauranteConsultado);
	}

	/**
	 * Test method for {@link com.devpredator.practicajpa.dao.impl.RestauranteDAOImpl#eliminar(java.lang.Long)}.
	 */
	@Test
	void testEliminar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.devpredator.practicajpa.dao.impl.RestauranteDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		List<Restaurante> restaurantes = this.restauranteDAO.consultar();
		
		assertTrue(restaurantes.size() > 0);
		
		restaurantes.forEach(restaurante ->{
			System.out.println(restaurante.toString());
		});
	}

	/**
	 * Test method for {@link com.devpredator.practicajpa.dao.impl.RestauranteDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		Restaurante restauranteConsultado = this.restauranteDAO.consultarById(14L);
		assertNotNull(restauranteConsultado);
		System.out.println(restauranteConsultado.toString());
	}
}
