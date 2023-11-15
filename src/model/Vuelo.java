package model;

public class Vuelo {
	
	public final static int NUMBER_OF_ATTRIBUTES = 5;

//	Attributes
	private String destino;
	private String horaSalida;
	private String horaLlegada;
	private String tarifa;
	private Double Coste;
	
//	Constructor
	public Vuelo(String destino, String horaSalida, String horaLlegada, String tarifa, Double coste) {
		super();
		this.destino = destino;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.tarifa = tarifa;
		Coste = coste;
	}
	public Vuelo(String destino, String horaSalida, String horaLlegada, String tarifa, int coste) {
		this(destino, horaSalida, horaLlegada, tarifa, (double) coste);
	}
	
//	Getters
	public String getDestino() {
		return destino;
	}
	public String getHoraSalida() {
		return horaSalida;
	}
	public String getHoraLlegada() {
		return horaLlegada;
	}
	public String getTarifa() {
		return tarifa;
	}
	public Double getCoste() {
		return Coste;
	}
	
	
	
}
