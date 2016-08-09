package org.baikal.dtnsat;

//import static org.assertj.core.api.Assertions.setRemoveAssertJRelatedElementsFromStackTrace;

import org.baikal.dtnsat.model.Orbit;
import org.baikal.dtnsat.model.Satellite;
import org.baikal.dtnsat.repository.SatelliteRepository;
import org.baikal.dtnsat.repository.SimulationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class DtnSatSbApplication {
	
	private static final Logger log = LoggerFactory.getLogger(DtnSatSbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DtnSatSbApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner SatTest(SatelliteRepository repo) {
		return (args) -> {
			log.info("TEST");
			//Satellite sat = new Satellite("MiSat");
			//sat.setOrbit(new Orbit(0.01, 10000.0, 0.0, 0.0, 0.0, 	0.0));
			
			
			//log.info("Nombre del satelite creado "+sat.getName());
			
			//repo.save(sat);
			
			//Creo un satellite con sus elementos orbitales
		
		};
		/*
		return (args) -> {
			// save a couple of customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
            log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
            log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (Customer bauer : repository.findByLastName("Bauer")) {
				log.info(bauer.toString());
			}
            log.info("");
		};
		*/
	}

}


