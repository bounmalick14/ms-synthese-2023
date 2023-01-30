package ma.enset.customerservice;


import ma.enset.customerservice.entity.Customer;
import ma.enset.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;


@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository,
	                                    RepositoryRestConfiguration restConfiguration){
		return args -> {

			restConfiguration.exposeIdsFor(Customer.class);
			customerRepository.save(Customer.builder().name("diallo").email("diallo@gmail.com").build());
			customerRepository.save(Customer.builder().name("bah").email("bah@gmail.com").build());
			customerRepository.save(Customer.builder().name("malick").email("malick@gmail.com").build());
			customerRepository.save(Customer.builder().name("oumar").email("oumar@gmail.com").build());
			customerRepository.save(Customer.builder().name("mohamed").email("mohamed@gmail.com").build());
			customerRepository.save(Customer.builder().name("karim").email("karim@gmail.com").build());
		};
	}
}
