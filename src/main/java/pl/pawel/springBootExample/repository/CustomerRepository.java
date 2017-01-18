package pl.pawel.springBootExample.repository;

import org.springframework.data.repository.CrudRepository;
import pl.pawel.springBootExample.entity.Customer;

import java.util.List;


public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    List<Customer> findByFirstName(String firstName);

    // @Query("SELECT COUNT(u) FROM Customer u WHERE u.lastName=:lastName")
    //Long counCustomer(@Param("lastName") String lastName);
    public long countByLastName(String lastName);
}
