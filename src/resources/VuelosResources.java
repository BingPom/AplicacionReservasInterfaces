package resources;

import java.util.ArrayList;

import gui.login.Login;
import model.Tarifa;
import model.Vuelo;
import resources.messages.Messages;

public class VuelosResources {

	public static ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>() {
		private static final long serialVersionUID = 1L;

	{
				add(new Vuelo("Bilbao", "5:30", "7:30", Tarifa.BUSINESS, 200));
				add(new Vuelo("Bilbao", "10:40", "12:45", Tarifa.TURISTA, 100));
				add(new Vuelo("Bilbao", "23:15", "3:10", Tarifa.TURISTA, 150));
				add(new Vuelo("Bilbao", "20:00", "22:25", Tarifa.TURISTA, 130));
				add(new Vuelo("Bilbao", "15:30", "18:50", Tarifa.BUSINESS, 180));
				add(new Vuelo("Bilbao", "12:50", "14:30", Tarifa.TURISTA, 200));
				add(new Vuelo("Bilbao", "14:20", "17:15", Tarifa.TURISTA, 170));
				add(new Vuelo("Bilbao", "2:45", "6:00", Tarifa.TURISTA, 150));
				add(new Vuelo("Madrid", "2:40", "4:50", Tarifa.BUSINESS, 300));
				add(new Vuelo("Madrid", "0:30", "6:45", Tarifa.TURISTA, 250));
				add(new Vuelo("Madrid", "7:30", "10:30", Tarifa.TURISTA, 180));
				add(new Vuelo("Madrid", "5:20", "7:10", Tarifa.TURISTA, 200));
				add(new Vuelo("Madrid", "17:15", "23:25", Tarifa.BUSINESS, 230));
				add(new Vuelo("Oporto", "6:30", "8:10", Tarifa.BUSINESS, 250));
				add(new Vuelo("Oporto", "4:50", "7:40", Tarifa.BUSINESS, 340));
				add(new Vuelo("Oporto", "14:20", "16:30", Tarifa.BUSINESS, 260));
				add(new Vuelo("Oporto", "12:15", "14:35", Tarifa.TURISTA, 210));
				add(new Vuelo("Oporto", "9:40", "11:20", Tarifa.TURISTA, 180));
			}};

	public static Object[][] toObjectMatrix() {
		Object[][] objects = new Object[vuelos.size()][Vuelo.NUMBER_OF_ATTRIBUTES];
		for (int i = 0; i < objects.length; i++) {
			objects[i][0] = vuelos.get(i).getDestino();
			objects[i][1] = vuelos.get(i).getHoraSalida();
			objects[i][2] = vuelos.get(i).getHoraLlegada();
			switch (vuelos.get(i).getTarifa()) {
			case BUSINESS:
				objects[i][3] = "Business";
				break;
			case TURISTA:
				objects[i][3] = Messages.getMessage(Login.user.getLanguage(), "Turista");
				break;
			default:
				objects[i][3] = "";
				break;
			}
			objects[i][4] = vuelos.get(i).getCoste().toString();
		}
		return objects;
	}

	public static Object[] getDestinos() {
		ArrayList<String> destinos = new ArrayList<String>();
		for (Vuelo vuelo : vuelos) {
			if (!destinos.contains(vuelo.getDestino())) {
				destinos.add(vuelo.getDestino());
			}
		}
		return Object2StringArray(destinos.toArray());
	}

	public static String[] Object2StringArray(Object[] objects) {
		String[] strings = new String[objects.length];
		for (int i = 0; i < strings.length; i++) {
			strings[i] = objects[i].toString();
		}
		return strings;
	}

	public static void addVuelo(Vuelo vuelo) {
		vuelos.add(vuelo);
	}
}
