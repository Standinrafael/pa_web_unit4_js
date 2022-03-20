package ec.edu.uce.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long tiempoInicio= System.currentTimeMillis();
		
		List<Integer> lista= new ArrayList<>();
		for(int i=1;i<=1000;i++) {
			lista.add(i);
		}
		
		List<String> listaS=lista.stream().map(numero->convertirNumero(numero)).collect(Collectors.toList());
		listaS.forEach(System.out::println);
		
		long tiempoFin=System.currentTimeMillis();
		long tiempo=(tiempoFin-tiempoInicio)/1000;
		System.out.println("Tiempo Total: "+tiempo+" seg");
	}
	
	private static String convertirNumero(Integer numero) {
		System.out.println(Thread.currentThread().getName());
		try {
			TimeUnit.MILLISECONDS.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "N:"+numero.toString();
	}
}
