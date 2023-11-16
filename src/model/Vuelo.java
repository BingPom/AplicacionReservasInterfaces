package model;

public class Vuelo {
	
	public final static int NUMBER_OF_ATTRIBUTES = 5;

//	Attributes
	private String destino;
	private String horaSalida;
	private String horaLlegada;
	private Tarifa tarifa;
	private Double Coste;
	
//	Constructor
	public Vuelo(String destino, String horaSalida, String horaLlegada, Tarifa tarifa, Double coste) {
		super();
		this.destino = destino;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.tarifa = tarifa;
		Coste = coste;
	}
	
	public Vuelo(String destino, String horaSalida, String horaLlegada, Tarifa tarifa, int coste) {
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
	public Tarifa getTarifa() {
		return tarifa;
	}
	public Double getCoste() {
		return Coste;
	}
	
	public static String[] getFields(Language lang) {
		switch(lang) {
			case ENGLISH:
				return new String[] {"Destination", "Departure", "Arrival", "Class", "Eur"};
			case ESPAÑOL:
				return new String[] {"Destino", "Hora salida", "Hora llegada", "Tarifa", "Eur"};
			default:
				return null;
		}
	}
	
}
