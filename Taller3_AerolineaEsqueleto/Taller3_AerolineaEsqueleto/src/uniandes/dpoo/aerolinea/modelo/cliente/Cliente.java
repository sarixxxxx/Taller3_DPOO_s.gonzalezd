package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.Collection;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	private java.util.List<Tiquete> tiquetesSinUsar;
	private java.util.List<Tiquete> tiquetesUsados;
	
	public Cliente(List<Tiquete> tiquetesSinUsar, List<Tiquete> tiquetesUsados) {
		super();
		this.tiquetesSinUsar = tiquetesSinUsar;
		this.tiquetesUsados = tiquetesUsados;
	}
	
	public abstract String getTipoCliente();
	public abstract String getIdentificador();
	public void agregarTiquete(Tiquete tiquete) {
		this.tiquetesSinUsar.add(tiquete);
	}
	public int calcularValorTotalTiquetes() {
		int total=0;
		for (Tiquete tiquete:tiquetesUsados) {
			total+=tiquete.getTarifa();
		}
		for (Tiquete tiquete:tiquetesSinUsar) {
			total+=tiquete.getTarifa();
		}
		return total;
		
	}
	public void usarTiquetes(Vuelo vuelo) {
		Collection<Tiquete> tiquetesDelVuelo=vuelo.getTiquetes();
		for (Tiquete tiquete:tiquetesDelVuelo) {
			int posicion=tiquetesSinUsar.indexOf(tiquete);
			tiquetesUsados.add(tiquete);
			tiquetesSinUsar.remove(posicion);
		}
	}
	public int calcularValorTotalTiquetesSinUsar() {
		int total=0;
		
		for (Tiquete tiquete:tiquetesSinUsar) {
			total+=tiquete.getTarifa();
		}
		return total;
		
	}

	public java.util.List<Tiquete> getTiquetesSinUsar() {
		return tiquetesSinUsar;
	}

	public java.util.List<Tiquete> getTiquetesUsados() {
		return tiquetesUsados;
	}

	
	
}
