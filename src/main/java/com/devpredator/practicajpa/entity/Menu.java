/**
 * 
 */
package com.devpredator.practicajpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author 4PF28LA_2004
 *
 */
@Entity
@Table(name = "menu")
public class Menu {

	/**
	 * Id del Menu.
	 */
	@Id
	@Column(name="idMenu")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMenu;
	/**
	 * Clave del Menu.
	 */
	@Column(name="clave")
	private String clave;
	/**
	 * Descripcion del Menu.
	 */
	@Column(name="descripcion")
	private String descripcion;
	/**
	 * Fecha de creacion del Menu.
	 */
	@Column(name="fechaCreacion")
	private LocalDateTime fechaCreacion;
	/**
	 * Fecha de modificacion del Menu.
	 */
	@Column(name="fechaModificacion")
	private LocalDateTime fechaModificacion;
	/**
	 * Estatus del Menu.
	 */
	@Column(name="estatus")
	private boolean estatus;

	/**
	 * @return the idMenu
	 */
	public Long getIdMenu() {
		return idMenu;
	}

	/**
	 * @param idMenu the idMenu to set
	 */
	public void setIdMenu(Long idMenu) {
		this.idMenu = idMenu;
	}

	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the fechaCreacion
	 */
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the fechaModificacion
	 */
	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the estatus
	 */
	public boolean isEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Menu [idMenu=" + idMenu + ", clave=" + clave + ", descripcion=" + descripcion + ", fechaCreacion="
				+ fechaCreacion + ", fechaModificacion=" + fechaModificacion + ", estatus=" + estatus + "]";
	}
}
