/**
 * 
 */
package com.devpredator.practicajpa.dao.impl;

import java.util.List;
import com.devpredator.practicajpa.dao.RestauranteDAO;
import com.devpredator.practicajpa.entity.Restaurante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/**
 * Clase que implementa los metodos del CRUD para las transacciones a la tabla
 * Restaurante.(EntityManager) Persistence
			.createEntityManagerFactory("persistenceDevPredator");
 * 
 * @author Calistos
 *
 */
public class RestauranteDAOImpl implements RestauranteDAO {

	public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceDevPredator");
			
			

	@Override
	public void guardar(Restaurante restaurante) {
		// Entity Manager:
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		// Entity Transaction:
		EntityTransaction et = em.getTransaction();

		// Comenzamos la transaccion:
		et.begin();

		try {
			// Realizamos la operacion de persistir en la DB:
			em.persist(restaurante);
			// Confirmamos los datos en la DB.
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				// Cancelamos la transaccion si algo sale mal:
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			// Cerramos la transaccion con la DB.
			em.close();
		}
	}

	@Override
	public void actualizar(Restaurante restaurante) {
		// Entity Manager:
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		// Entity Transaction:
		EntityTransaction et = em.getTransaction();

		// Comenzamos la transaccion:
		et.begin();

		try {
			// Realizamos la operacion de actualizar en la DB:
			em.merge(restaurante);
			// Confirmamos los datos en la DB:
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				// Cancelamos la transaccion si algo sale mal:
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			// Cerramos la transaccion con la DB.
			em.close();
		}

	}

	@Override
	public void eliminar(Long id) {
		// Entity Manager:
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		// Buscamos en la DB al objeto:
		Restaurante restauranteConsultado = em.find(Restaurante.class, id);

		// Entity Transaction:
		EntityTransaction et = em.getTransaction();

		// Comenzamos la transaccion:
		et.begin();

		try {
			// Realizamos la operacion de eliminar de la DB:
			em.remove(restauranteConsultado);
			// Confirmamos la operacion en la DB:
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				// Cancelamos la transaccion si algo sale mal:
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			// Cerramos la transaccion con la DB.
			em.close();
		}
	}

	@Override
	public List<Restaurante> consultar() {
		// Entity Manager:
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		// Entity Transaction:
		TypedQuery<Restaurante> tq = (TypedQuery<Restaurante>) em.createQuery("FROM Restaurante ORDER BY nombre");

		// Devolvemos el listado encontrado de la DB:
		return tq.getResultList();
	}

	@Override
	public Restaurante consultarById(Long id) {
		// Entity Manager:
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		// Creamos un objeto para guardar la info buscada:
		Restaurante restauranteConsultado = em.find(Restaurante.class, id);

		// Verificamos si los datos son o no nulos:
		if (restauranteConsultado == null) {
			throw new EntityNotFoundException("El restaurante con id: " + id + ", no fue encontrado en la DB.");
		}

		// Devolvemos el objeto consultado:
		return restauranteConsultado;
	}

}
