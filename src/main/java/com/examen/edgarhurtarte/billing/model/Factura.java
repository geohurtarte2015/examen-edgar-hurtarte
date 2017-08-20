package com.examen.edgarhurtarte.billing.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Entity
@Table(name="FACTURA")
public class Factura {
	
	
	@Id
    @GeneratedValue
	@Column(name="num_factura")
	private int id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	
	
	@Column(name="fecha")
	private String fecha;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
		@JoinTable(name = "FACTURA_PRODUCTO", 
	    joinColumns = { @JoinColumn(name = "num_factura") }, 
	    inverseJoinColumns = { @JoinColumn(name = "id_producto") })
	private List<Producto> productos = new ArrayList<Producto>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
	
	
	

}

