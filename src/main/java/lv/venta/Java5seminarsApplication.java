package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Product;
import lv.venta.model.ProductType;
import lv.venta.repo.IProductRepo;
//http://localhost:8080/h2-console
//server.port =9000 var mainit port application properties 
@SpringBootApplication
public class Java5seminarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Java5seminarsApplication.class, args);
	}
	@Bean
	public CommandLineRunner testRepo(IProductRepo prodRepo) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				Product prod = new Product("Abols", 1, "1kg abols liels", 10, ProductType.fruit);
				Product prod1 = new Product("Bumbieris", 0.99, "1kg bumbieris liels", 30, ProductType.fruit);
				
				prodRepo.save(prod);
				prodRepo.save(prod1);
				
				
				
			}
		};
		
	}

}
