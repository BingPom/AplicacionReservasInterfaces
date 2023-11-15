package utils;

import model.Vuelo;
import resources.VuelosResources;

public class ManageVuelos {

	public void addVuelo(Vuelo vuelo) {
		VuelosResources.vuelos.add(vuelo);
	}
	
}
