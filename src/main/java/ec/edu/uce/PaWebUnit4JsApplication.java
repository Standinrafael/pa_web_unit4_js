package ec.edu.uce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.service.IProcesamientoFacultadService;

@SpringBootApplication
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
		
		Integer valor1=this.facultadService.calcularDeuda("123", 4);
		Integer valor2=this.facultadService.calcularDeuda("456", 4);
		Integer valor3=this.facultadService.calcularDeuda("789", 4);
		Integer valor4=this.facultadService.calcularDeuda("111", 4);
		
		LOG.info("Total: "+(valor1+valor2+valor3+valor4));
		long tFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tFinal - inicio) / 1000;
		LOG.info(tiempoTranscurrido + " seg");
	}

}
