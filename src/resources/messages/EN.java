package resources.messages;

import java.util.HashMap;

public class EN {

	final static HashMap<String, String> messages = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;

	{
		put("Turista", "Turist");
//		DatosVuelos
		put("Operaciones", "Operations");
		put("Individual", "Individual");
		put("Doble", "Double");
		put("Múltiple", "Multiple");
		put("Reservar habitación", "Book a room");
		put("Núm. habitaciones", "Num. of rooms");
		put("Seleccionar vuelo", "Select Flight");
		put("Reservar Vuelo", "Book a Flight");
		put("Añadir Vuelo", "Add Flight");
		put("Hora Llegada: ", "Departure: ");
		put("Hora Salida: ", "Arrival: ");
//		Datos Reserva
		put("Resumen reserva", "Booking summary");
		put("Has reservado ", "You have booked ");
		put("un vuelo desde ", "a flight from ");
		put(" a las ", " at ");
		put(" y una habitación ", " and a room ");
		put("individual.", "for one.");
		put("doble.", "for two.");
		put("para ", "para ");
		put("persona.", "person.");
		put(" personas.", " people.");
		put("Nada ha sido reservado.", "Nothing booked.");
		put("Número de huéspedes no válido", "Number of guests not valid");
//		TablaVuelos
		put("Vuelos Disponibles", "Available Flights");
		put("Selecciona un vuelo desde: ", "Selecta flight from: ");
//		General
		put("Aceptar", "OK");
		put("Cancelar", "Cancel");
	}};
	
	public static HashMap<String, String> getMessages() {
		return messages;
	}
}
