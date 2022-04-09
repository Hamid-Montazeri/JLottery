package ir.mapsa.jlottery.jlottery.service;

import ir.mapsa.jlottery.jlottery.base.BaseService;
import ir.mapsa.jlottery.jlottery.dto.PersonDTO;
import ir.mapsa.jlottery.jlottery.model.Person;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public interface IPersonService extends BaseService<Person, PersonDTO> {

    Optional<Person> findUserByUsernameAndPassword(String username, String password);

    ResponseEntity<String> generateToken(Person person, HttpServletResponse response);

}
