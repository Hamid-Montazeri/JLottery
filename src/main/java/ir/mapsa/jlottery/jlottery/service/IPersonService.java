package ir.mapsa.jlottery.jlottery.service;

import ir.mapsa.jlottery.jlottery.base.BaseService;
import ir.mapsa.jlottery.jlottery.dto.PersonDTO;
import ir.mapsa.jlottery.jlottery.model.Person;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;

public interface IPersonService extends BaseService<Person, PersonDTO> {

    ResponseEntity<String> generateToken(Person person, HttpServletResponse response);

}
