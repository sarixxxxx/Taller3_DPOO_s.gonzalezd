package uniandes.dpoo.aerolinea.modelo;

/**
 * Esta clase tiene la información de una ruta entre dos aeropuertos que cubre una aerolínea.
 */
public class Ruta
{
    
	// TODO completar
	public String horaSalida;
	public String horaLlegada;
	public String codigoRuta;
	public Aeropuerto origen;
	public Aeropuerto destino;
	
	public String getHoraSalida() {
		return horaSalida;
	}

	public String getHoraLlegada() {
		return horaLlegada;
	}

	public String getCodigoRuta() {
		return codigoRuta;
	}

	public Aeropuerto getOrigen() {
		return origen;
	}

	public Aeropuerto getDestino() {
		return destino;
	}
	public int getDuracion() {
		//int minutosLlegada=getMinutos(this.horaLlegada);
		//int minutosSalida=getMinutos(this.horaSalida);
		int horasLlegada=getHoras(this.horaLlegada);
		int horasSalida=getHoras(this.horaSalida);
		int duracion;
		if (horasLlegada < horasSalida) {
			duracion=(24-horasSalida)+horasLlegada;
		} else {
			duracion= horasLlegada-horasSalida;
		}
		return duracion;
		
	}

    /**
     * Dada una cadena con una hora y minutos, retorna los minutos.
     * 
     * Por ejemplo, para la cadena '715' retorna 15.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de minutos entre 0 y 59
     */
    public static int getMinutos( String horaCompleta )
    {
        int minutos = Integer.parseInt( horaCompleta ) % 100;
        return minutos;
    }

    /**
     * Dada una cadena con una hora y minutos, retorna las horas.
     * 
     * Por ejemplo, para la cadena '715' retorna 7.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de horas entre 0 y 23
     */
    public static int getHoras( String horaCompleta )
    {
        int horas = Integer.parseInt( horaCompleta ) / 100;
        return horas;
    }
    public Ruta (Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, String horaSalida, String horaLlegada, String codigoRuta) {
    	this.origen=aeropuertoOrigen;
    	this.destino=aeropuertoDestino;
    	this.horaSalida=horaSalida;
    	this.horaLlegada=horaLlegada;
    	this.codigoRuta=codigoRuta;
    	
    }
    
    
}
