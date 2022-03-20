package ec.edu.uce;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import ec.edu.uce.service.IProcesamientoFacultadService;

@SpringBootApplication
@EnableAsync
public class PaWebUnit4JsApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(PaWebUnit4JsApplication.class);

	@Autowired
	private IProcesamientoFacultadService facultadService;

	public static void main(String[] args) {
		SpringApplication.run(PaWebUnit4JsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		long inicio = System.currentTimeMillis();

		// Procesamiento asincrono pero sin manejo de respuesta por cada hilo

//		Integer valor1=this.facultadService.calcularDeuda("123", 4);
//		Integer valor2=this.facultadService.calcularDeuda("456", 4);
//		Integer valor3=this.facultadService.calcularDeuda("789", 4);
//		Integer valor4=this.facultadService.calcularDeuda("111", 4);

//		LOG.info("Total: "+(valor1+valor2+valor3+valor4));

		// Procesamiento asincrono pero sin manejo de respuesta por cada hilo

		CompletableFuture<Integer> valor1 = this.facultadService.calcularDeudaFuture("123", 4);
		CompletableFuture<Integer> valor2 = this.facultadService.calcularDeudaFuture("456", 4);
		CompletableFuture<Integer> valor3 = this.facultadService.calcularDeudaFuture("789", 4);
		CompletableFuture<Integer> valor4 = this.facultadService.calcularDeudaFuture("111", 4);

		// Sentencia que espera que terminen de procesar todos los hilos
		CompletableFuture.allOf(valor1, valor2, valor3, valor4).join();

		// Esperar que se procesen toos los hilos
		LOG.info("Total: " + (valor1.get() + valor2.get() + valor3.get() + valor4.get()));
		long tFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tFinal - inicio) / 1000;
		LOG.info(tiempoTranscurrido + " seg");
	}

}
