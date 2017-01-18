package pl.pawel.springBootExample.repository;

import org.springframework.data.repository.CrudRepository;
import pl.pawel.springBootExample.domain.Proverb;


/**
 * Created by pawel on 18.01.2017.
 */
public interface ProverbRepository extends CrudRepository<Proverb, Long> {
}


