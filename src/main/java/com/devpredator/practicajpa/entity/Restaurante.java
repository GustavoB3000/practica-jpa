/**
 * 
 */
package com.devpredator.practicajpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * Clase que representa a una entidad del tipo Restaurante.
 * @author Calistos
 */
@Entity
@Table(name="restaurante")
public class Restaurante {

	/**
	 * Id del Restaurante.
	 */
	@Id
	@Column(name="idRestaurante")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRestaurante;
	/**
	 * Nombre del Restaurante.
	 */
	@Column(name="nombre")
	private String nombre;
	/**
	 * Imagen del Restaurante,
	 */
	@Column(name="imagen")
	private String imagen;
	/**
	 * Slogan del Restaurante.
	 */
	@Column(name="slogan")
	private String slogan;
	/**
	 * Tipo de restaurante del Restaurante.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTipoRestaurante")
	@Cascade(CascadeType.ALL)
	private TipoRestaurante tipoRestaurante;
	/**
	 * Fecha de creacion del Restaurante.
	 */
	@Column(name="fechaCreacion")
	private LocalDateTime fechaCreacion;
	/**
	 * Fecha de modificacion del Restaurante.
	 */
	@Column(name="fechaModificacion")
	private LocalDateTime fechaModificacion;
	/**
	 * Estatus del Restaurante.
	 */
	@Column(name="estatus")
	private boolean estatus;
	/**
	 * Menu del Restaurante.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idMenu")
	@Cascade(CascadeType.ALL)
	private Menu menu;
	
	/**
	 * @return the idRestaurante
	 */
	public Long getIdRestaurante() {
		return idRestaurante;
	}
	/**
	 * @param idRestaurante the idRestaurante to set
	 */
	public void setIdRestaurante(Long idRestaurante) {
		this.idRestaurante = idRestaurante;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}
	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	/**
	 * @return the slogan
	 */
	public String getSlogan() {
		return slogan;
	}
	/**
	 * @param slogan the slogan to set
	 */
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	/**
	 * @return the tipoRestaurante
	 */
	public TipoRestaurante getTipoRestaurante() {
		return tipoRestaurante;
	}
	/**
	 * @param tipoRestaurante the tipoRestaurante to set
	 */
	public void setTipoRestaurante(TipoRestaurante tipoRestaurante) {
		this.tipoRestaurante = tipoRestaurante;
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
	/**
	 * @return the menu
	 */
	public Menu getMenu() {
		return menu;
	}
	/**
	 * @param menu the menu to set
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	@Override
	public String toString() {
		return "Restaurante [idRestaurante=" + idRestaurante + ", nombre=" + nombre + ", imagen=" + imagen + ", slogan="
				+ slogan + ", tipoRestaurante=" + tipoRestaurante + ", fechaCreacion=" + fechaCreacion
				+ ", fechaModificacion=" + fechaModificacion + ", estatus=" + estatus + ", menu=" + menu + "]";
	}
}
