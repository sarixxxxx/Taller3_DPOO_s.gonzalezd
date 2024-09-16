package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural extends Cliente{
	public static final java.lang.String NATURAL="Natural";
	private java.lang.String nombre;
	

	public ClienteNatural(String nombre) {
		super();
		this.nombre = nombre;
	}
	

	@Override
	public String getTipoCliente() {
		// TODO Auto-generated method stub
		return NATURAL;
	}

	@Override
	public String getIdentificador() {
		// TODO Auto-generated method stub
		return this.nombre;
	}
	
}
