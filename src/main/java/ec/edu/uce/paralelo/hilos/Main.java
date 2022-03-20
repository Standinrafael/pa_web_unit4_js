package ec.edu.uce.paralelo.hilos;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long tiempoInicial=System.currentTimeMillis();
		
		Cajero cajero1= new Cajero("Jorge",Arrays.asList(2,2,3,4,5));
		Cajero cajero2= new Cajero("Luis",Arrays.asList(1,2,2,3));
		Cajero cajero3= new Cajero("Felipe",Arrays.asList(3,2,2,3));
		
		GestorAtencion gestor1=new GestorAtencion();
		gestor1.procesar(cajero1,tiempoInicial);
		
		GestorAtencion gestor2=new GestorAtencion();
		gestor2.procesar(cajero2,tiempoInicial);
		
		GestorAtencion gestor3=new GestorAtencion();
		gestor3.procesar(cajero3,tiempoInicial);
		
		long tiempoFinal=System.currentTimeMillis();
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		System.out.println("Tiempor transcurrido "+ tiempoTranscurrido);
	}
}
