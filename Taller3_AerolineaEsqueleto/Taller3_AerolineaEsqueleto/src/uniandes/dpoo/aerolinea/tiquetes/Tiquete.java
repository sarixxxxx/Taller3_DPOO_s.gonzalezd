package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {
	private Cliente cliente;
	private Vuelo vuelo;
	private String codigo;
	private int tarifa;
	private boolean usado;
	public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComprador, int tarifa) {
		super();
		this.codigo = codigo;
		this.tarifa = tarifa;
		this.cliente=clienteComprador;
		this.tarifa=tarifa;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public Vuelo getVuelo() {
		return vuelo;
	}
	public String getCodigo() {
		return codigo;
	}
	public int getTarifa() {
		return tarifa;
	}
	public void marcarComoUsado() {
		this.usado= true;
	}
	public boolean esUsado() {
		return usado;
	}
	
}
