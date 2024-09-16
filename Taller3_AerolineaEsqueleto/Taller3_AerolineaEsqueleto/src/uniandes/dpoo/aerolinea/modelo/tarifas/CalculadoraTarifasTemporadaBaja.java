package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas{
	protected final int COSTO_POR_KM_NATURAL=600;
	protected final int COSTO_POR_KM_CORPORATIVO=900;
	protected final double DESCUENTO_PEQ=0.02;
	protected final double DESCUENTO_MEDIANAS=0.1;
	protected final double DESCUENTO_GRANDES=0.2;
	


	public CalculadoraTarifasTemporadaBaja() {
		super();
	}
	public int calcularCostoBase​(Vuelo vuelo,Cliente cliente) {
		int distancia= this.calcularDistanciaVuelo​(vuelo.getRuta());
		
		if (cliente.getTipoCliente()=="Natural") {
			return (int)(COSTO_POR_KM_NATURAL*distancia);
		} else {
			return (int)(COSTO_POR_KM_CORPORATIVO*distancia);
		}}
	
	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		String tipo=cliente.getTipoCliente();
		if (tipo=="Natural") {
			return 0;
		} else if (tipo=="Corporativo") {
			ClienteCorporativo clienteCorporativo= (ClienteCorporativo) cliente;
			switch (clienteCorporativo.getTamanoEmpresa()) {
				case 1:
					return DESCUENTO_GRANDES;
			case 2:
					return DESCUENTO_MEDIANAS;
			case 3:
					return DESCUENTO_PEQ;
			}
		}
		return 0;
	
	}
	
}
