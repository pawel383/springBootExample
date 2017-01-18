package pl.pawel.springBootExample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.pawel.springBootExample.domain.Customer;
import pl.pawel.springBootExample.repository.CustomerRepository;
import pl.pawel.springBootExample.usecase.UserCreate;

import java.util.Collection;

/**
 * Created by pawel on 18.01.2017.
 */
@RestController
@RequestMapping("/all")
public class CustomerService {

    @Autowired
    CustomerRepository repository;


    @Autowired
    UserCreate userCreate;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Customer>> getAllCustomers() {
        userCreate.oneUser();
        return new ResponseEntity<>((Collection<Customer>) repository.findAll(), HttpStatus.OK);
    }

}

