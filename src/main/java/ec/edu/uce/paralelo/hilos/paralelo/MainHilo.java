package ec.edu.uce.paralelo.hilos.paralelo;

import java.util.Arrays;

public class MainHilo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial = System.currentTimeMillis();

		CajeroHilo cajero1 = new CajeroHilo("Jorge", Arrays.asList(2, 2, 3, 4, 5));
		CajeroHilo cajero2 = new CajeroHilo("Luis", Arrays.asList(1, 2, 2, 3));
		CajeroHilo cajero3 = new CajeroHilo("Felipe", Arrays.asList(3, 2, 2, 3));

		GestorAtencionHilo gestor1 = new GestorAtencionHilo(cajero1, tiempoInicial);
		gestor1.start();// procesar

		GestorAtencionHilo gestor2 = new GestorAtencionHilo(cajero2, tiempoInicial);
		gestor2.start();

		GestorAtencionHilo gestor3 = new GestorAtencionHilo(cajero3, tiempoInicial);
		gestor3.start();

		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println("Tiempor transcurrido " + tiempoTranscurrido);
	}
}
