package resources;

import java.util.ArrayList;
import java.util.List;

import model.Vuelo;

public class VuelosResources {

	public static List<Vuelo> vuelos = List.of(
				new Vuelo("Bilbao", "5:30", "7:30", "Business", 200),
				new Vuelo("Bilbao", "10:40", "12:45", "Turista", 100),
				new Vuelo("Bilbao", "23:15", "3:10", "Turista", 150),
				new Vuelo("Bilbao", "20:00", "22:25", "Turista", 130),
				new Vuelo("Bilbao", "15:30", "18:50", "Business", 180),
				new Vuelo("Bilbao", "12:50", "14:30", "Turista", 200),
				new Vuelo("Bilbao", "14:20", "17:15", "Turista", 170),
				new Vuelo("Bilbao", "2:45", "6:00", "Turista", 150),
				new Vuelo("Madrid", "2:40", "4:50", "Business", 300),
				new Vuelo("Madrid", "0:30", "6:45", "Turista", 250),
				new Vuelo("Madrid", "7:30", "10:30", "Turista", 180),
				new Vuelo("Madrid", "5:20", "7:10", "Turista", 200),
				new Vuelo("Madrid", "17:15", "23:25", "Business", 230),
				new Vuelo("Oporto", "6:30", "8:10", "Business", 250),
				new Vuelo("Oporto", "4:50", "7:40", "Business", 340),
				new Vuelo("Oporto", "14:20", "16:30", "Business", 260),
				new Vuelo("Oporto", "12:15", "14:35", "Turista", 210),
				new Vuelo("Oporto", "9:40", "11:20", "Turista", 180),
				new Vuelo("Azul como el mar", "9:40", "11:20", "Azul", 180)
			);
	
	public static Object[][] toObjectMatrix() {
		Object[][] objects = new Object[vuelos.size()][Vuelo.NUMBER_OF_ATTRIBUTES];
		for (int i = 0; i < objects.length; i++) {
			objects[i][0] = vuelos.get(i).getDestino();
			objects[i][1] = vuelos.get(i).getHoraSalida();
			objects[i][2] = vuelos.get(i).getHoraSalida();
			objects[i][3] = vuelos.get(i).getTarifa();
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
	
}
