package main;

import model.Tarifa;
import model.Vuelo;
import resources.VuelosResources;

public class Main {

	public static void main(String[] args) {
		System.out.println("intento");
		VuelosResources.addVuelo(new Vuelo("sdfsd", "asdsad", "asdas", Tarifa.BUSINESS, 123.0));
		System.out.println("lsito");
	}

}
