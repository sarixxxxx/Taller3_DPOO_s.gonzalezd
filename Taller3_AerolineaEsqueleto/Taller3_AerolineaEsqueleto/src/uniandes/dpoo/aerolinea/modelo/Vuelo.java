package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;
import java.util.Map;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	private String fecha;
	private Ruta ruta;
	private Avion avion;
	private Map<String,Tiquete> tiquetes;
	public Vuelo(Ruta ruta, String fecha, Avion avion) {
		super();
		this.fecha = fecha;
		this.ruta = ruta;
		this.avion = avion;
	}
	public String getFecha() {
		return fecha;
	}
	public Ruta getRuta() {
		return ruta;
	}
	public Avion getAvion() {
		return avion;
	}
	public Collection<Tiquete> getTiquetes() {
		return tiquetes.values();
		
	}
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException {
		int capacidadTotal=avion.getCapacidad();
		int tiquetesVendidos= tiquetes.size();
		if (tiquetesVendidos+cantidad>capacidadTotal) {
			throw new VueloSobrevendidoException(this);
			
		}
		int valorTotal=0;
		int tarifa=calculadora.calcularTarifa(this, cliente);
		valorTotal+=tarifa*cantidad;
		for (int i=0; i<cantidad;i++) {
			Tiquete nuevoTiquete=GeneradorTiquetes.generarTiquete(this, cliente, tarifa);
			cliente.agregarTiquete(nuevoTiquete);
			cliente.usarTiquetes(this);
		}
		return valorTotal;
	}
	
}
