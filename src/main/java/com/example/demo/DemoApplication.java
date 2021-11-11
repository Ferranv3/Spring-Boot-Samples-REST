package com.example.demo;

import com.example.demo.astro.AstroPicEntity;
import com.example.demo.astro.AstroPicRepository;
import com.example.demo.customer.CustomerEntity;
import com.example.demo.customer.CustomerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	  @Bean
  	public CommandLineRunner demo(CustomerRepository repository) {
    return (args) -> {
      // save a few customers
      repository.save(new CustomerEntity("Jack", "Bauer", "uno@gmail.com"));
      repository.save(new CustomerEntity("Chloe", "O'Brian", "dos@gmail.com"));
      repository.save(new CustomerEntity("Kim", "Bauer", "tres@gmail.com"));
      repository.save(new CustomerEntity("David", "Palmer", "cuatro@gmail.com"));
      repository.save(new CustomerEntity("Michelle", "Dessler", "cinco@gmail.com"));

      // fetch all customers
      log.info("Customers found with findAll():");
      log.info("-------------------------------");
      for (CustomerEntity customer : repository.findAll()) {
        log.info(customer.toString());
      }
      log.info("");      
      // fetch an individual customer by ID
      CustomerEntity customer = repository.findById(1L);
      log.info("Customer found with findById(1L):");
      log.info("--------------------------------");
      log.info(customer.toString());
      log.info("");
      // fetch customers by last name
      log.info("Customer found with findByLastName('Bauer'):");
      log.info("--------------------------------------------");
      repository.findByLastName("Bauer").forEach(bauer -> {
        log.info(bauer.toString());
      });
      // for (Customer bauer : repository.findByLastName("Bauer")) {
      //  log.info(bauer.toString());
      // }
      log.info("");
    };
  }

  /*@Bean
  	public CommandLineRunner demo(AstroPicRepository repository) {
    return (args) -> {
      // save a few customers String date, String explanation, String hdurl, String url, String title
      repository.save(new AstroPicEntity("2021-11-09",
      "Why would you want to fake a universe? For one reason -- to better understand our real universe.","https://apod.nasa.gov/apod/image/2111/AIapods01_Geach_3840.jpg",
      "https://apod.nasa.gov/apod/image/2111/AIapods01_Geach_960.jpg",
      "All of These Space Images are Fake Except One", "image"));

      repository.save(new AstroPicEntity("2021-11-08",
      "Why, sometimes, does part of the Sun's atmosphere leap into space? The reason lies in changing magnetic fields that thread through the Sun's surface.","https://apod.nasa.gov/apod/image/2111/AIapods01_Geach_3840.jpg",
      "https://www.youtube.com/embed/7NykS2kv_k8?playlist=7NykS2kv_k8&loop=1;rel=0&autoplay=1",
      "A Filament Leaps from the Sun", "video"));
      
      // fetch all customers
      log.info("Customers found with findAll():");
      log.info("-------------------------------");
      for (AstroPicEntity astro : repository.findAll()) {
        log.info(astro.toString());
      }
      log.info("");
    };
  }*/

  @Bean
  public RestTemplate getRestTemplate(){
    return new RestTemplate();
  }
}
