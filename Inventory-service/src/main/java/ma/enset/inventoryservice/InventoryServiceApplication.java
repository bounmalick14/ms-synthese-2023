package ma.enset.inventoryservice;

import ma.enset.inventoryservice.entity.Product;
import ma.enset.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository,
                                        RepositoryRestConfiguration restConfiguration){
        return args -> {
           restConfiguration.exposeIdsFor(Product.class);
           productRepository.save(Product.builder().name("ordinateur").price(120000).quantity(10).build()) ;
           productRepository.save(Product.builder().name("souri").price(17000).quantity(10).build()) ;
           productRepository.save(Product.builder().name("clavier").price(100000).quantity(10).build()) ;
           productRepository.save(Product.builder().name("ecran").price(113000).quantity(10).build()) ;
           productRepository.save(Product.builder().name("imprimante").price(10000000).quantity(10).build()) ;
        };
    };
}
