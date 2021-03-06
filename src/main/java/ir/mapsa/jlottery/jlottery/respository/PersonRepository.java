package ir.mapsa.jlottery.jlottery.respository;

import ir.mapsa.jlottery.jlottery.base.BaseRepository;
import ir.mapsa.jlottery.jlottery.model.Person;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface PersonRepository extends BaseRepository<Person> {

    Optional<Person> findUserByUsername(String username);
    Optional<Person> findUserByUsernameAndPassword(String username, String password);
    Set<Person> findAllByScoreGreaterThan(Integer score);
    Boolean existsByUsername(String username);

}
