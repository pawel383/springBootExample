package pl.pawel.springBootExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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



    @Bean
    public int demo() throws Exception {
        return 0;
    }

//    @Bean
//    public RestTemplate restTemplate() {
//        log.info("Builder");
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate;
//    }

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
