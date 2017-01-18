package pl.pawel.springBootExample.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.pawel.springBootExample.domain.Customer;
import pl.pawel.springBootExample.repository.CustomerRepository;

/**
 * Created by pawel on 15.01.2017.
 */
@Component
public class UserCreate {

    @Autowired
    CustomerRepository repository;


    //@Bean
    public int oneUser() {
        repository.save(new Customer("Jack11", "Bauer11"));
        return 0;
    }


}
