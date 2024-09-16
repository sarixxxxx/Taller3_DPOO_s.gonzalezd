package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas{

	public CalculadoraTarifasTemporadaAlta() {
		super();
	}
	protected int COSTO_POR_KM=1000;
	public int calcularCostoBase​(Vuelo vuelo, Cliente cliente) {
		int distancia= this.calcularDistanciaVuelo​(vuelo.getRuta());
		return (int)(COSTO_POR_KM*distancia);
	}
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		//no estoy segura de lo que va acá
		return 0;
	}
}
