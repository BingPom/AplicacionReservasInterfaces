package resources.messages;

import java.util.HashMap;

public class ES {

	final static HashMap<String, String> messages = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;

	{
		put("Turista", "Turista");
//		DatosVuelos
		put("Operaciones", "Operaciones");
		put("Individual", "Individual");
		put("Doble", "Doble");
		put("Múltiple", "Múltiple");
		put("Reservar habitación", "Reservar habitación");
		put("Núm. habitaciones", "Núm. habitaciones");
		put("Seleccionar vuelo", "Seleccionar vuelo");
		put("Reservar Vuelo", "Reservar Vuelo");
		put("Añadir Vuelo", "Añadir Vuelo");
		put("Hora Llegada: ", "Hora Llegada: ");
		put("Hora Salida: ", "Hora Salida: ");
//		Datos Reserva
		put("Resumen reserva", "Resumen reserva");
		put("Has reservado ", "Has reservado ");
		put("un vuelo desde ", "un vuelo desde ");
		put(" a las ", " a las ");
		put(" y una habitación ", " y una habitación ");
		put("individual.", "individual.");
		put("doble.", "doble.");
		put("para ", "para ");
		put("persona.", "persona.");
		put(" personas.", " personas.");
		put("Nada ha sido reservado.", "Nada ha sido reservado.");
//		TablaVuelos
		put("Vuelos Disponibles", "Vuelos Disponibles");
		put("Selecciona un vuelo desde: ", "Selecciona un vuelo desde: ");
//		General
		put("Aceptar", "Aceptar");
		put("Cancelar", "Cancelar");
	}};
	
	public static HashMap<String, String> getMessages() {
		return messages;
	}
}
