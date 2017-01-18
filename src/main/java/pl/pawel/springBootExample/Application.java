package pl.pawel.springBootExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import pl.pawel.springBootExample.domain.Customer;
import pl.pawel.springBootExample.domain.Proverb;
import pl.pawel.springBootExample.restclient.Quote;
import pl.pawel.springBootExample.repository.CustomerRepository;
import pl.pawel.springBootExample.repository.ProverbRepository;
import pl.pawel.springBootExample.usecase.UserCreate;


@SpringBootApplication(scanBasePackages = {"pl.pawel"})
//@ComponentScan({"pl.pawel.customerRepository.CustomerRepository"})
//@EnableJpaRepositories("pl.pawel.customerRepository")
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProverbRepository proverbRepository;
    @Autowired
    UserCreate userCreate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    //@Autowired

    @Bean
    public int demo(RestTemplate restTemplate) throws Exception {
        //UserCreate userCreate = new UserCreate();
        // save a couple of customers
        customerRepository.save(new Customer("Jack", "Bauer"));
        customerRepository.save(new Customer("Chloe", "O'Brian"));
        customerRepository.save(new Customer("Kim", "Bauer"));
        customerRepository.save(new Customer("David", "Palmer"));
        customerRepository.save(new Customer("Michelle", "Dessler"));

        // fetch all customers
        log.info("Customers found with findAll():");
        log.info("-------------------------------");
        for (Customer customer : customerRepository.findAll()) {
            log.info(customer.toString());
        }
        log.info("");

        // fetch an individual customer by ID
        //Customer customer = customerRepository.findOne(120L);
//        log.info("Customer found with findOne(1L):");
//        log.info("--------------------------------");
//        log.info(customer.toString());
//        log.info("");

        // fetch customers by last name
        log.info("Customer found with findByLastName('Bauer'):");
        log.info("--------------------------------------------");
        for (Customer bauer : customerRepository.findByLastName("Bauer")) {
            log.info(bauer.toString());
        }
        log.info("");

        log.info("Customer found with findByFirstName('Kim'):");
        log.info("--------------------------------------------");
        for (Customer kim : customerRepository.findByFirstName("Kim")) {
            log.info(kim.toString());
        }
        log.info("");


        log.info("commandlineRunner");
        //ValueRepository pl.customerRepository;

        for (int i=1;i<10;i++){
            Quote quote = restTemplate.getForObject(
                    "http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            customerRepository.save(new Customer(quote.getType(), quote.getValue().getQuote()));
            Proverb proverb = new Proverb();
            proverb.setNo(Math.toIntExact(quote.getValue().getId()));
            proverb.setQuote(quote.getValue().getQuote());
            proverbRepository.save(proverb);

            log.info(quote.toString());
        }
        userCreate.oneUser();
        for (Customer customer2 : customerRepository.findAll()) {
            log.info(customer2.toString());
        }
        log.info("Customer numer is {}", customerRepository.countByLastName("Bauer"));
        return 0;
    }

    @Bean
    public RestTemplate restTemplate() {
        log.info("Builder");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

//	@Bean
//	public int run(RestTemplate restTemplate) throws Exception {
//		log.info("commandlineRunner");
//		//ValueRepository pl.customerRepository;
//		Quote quote = restTemplate.getForObject(
//				"http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
//		//pl.customerRepository.save(new Customer("Jack", "Bauer"));
//		log.info(quote.toString());
//		return 0;
//	}

}
