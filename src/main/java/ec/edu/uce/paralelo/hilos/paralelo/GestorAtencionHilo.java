package ec.edu.uce.paralelo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class GestorAtencionHilo extends Thread {

	private CajeroHilo cajero;
	private long tiempoInicial;
	
	public GestorAtencionHilo() {
		
	}
	
	public GestorAtencionHilo(CajeroHilo cajero, long tiempoInicial) {
		super();
		this.cajero = cajero;
		this.tiempoInicial = tiempoInicial;
	}


	//Sobreescribir metodo run
	@Override
	public void run() {
		
		this.procesar(this.cajero, this.tiempoInicial);
	}
	
	
	public void procesar(CajeroHilo cajero, long tiempoInicial) {
		System.out.println("Inicia atender cajero:"+cajero.getNombre());
		for(Integer tiempo: cajero.getClientes()) {
			
			this.atenderCliente(tiempo);
			
		}
		
		System.out.println("Finaliza atender cajero:"+cajero.getNombre());
		
		long tiempoTranscurrido=(System.currentTimeMillis()-tiempoInicial)/1000;
		System.out.println(tiempoTranscurrido+" seg de atencion por: "+cajero.getNombre());
	}
	
	private void atenderCliente(Integer tiempo) {
		System.out.println("Atendiendo a cliente: "+tiempo);
		System.out.println("Hilo "+Thread.currentThread().getName());
		try {
			//Se demora en la atencion
			TimeUnit.SECONDS.sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
