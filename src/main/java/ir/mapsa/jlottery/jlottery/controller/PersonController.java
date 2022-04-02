package ir.mapsa.jlottery.jlottery.controller;

import ir.mapsa.jlottery.jlottery.dto.PersonDTO;
import ir.mapsa.jlottery.jlottery.model.Person;
import ir.mapsa.jlottery.jlottery.service.IPersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final IPersonService personService;

    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody Person person, HttpServletResponse response) {
        return personService.generateToken(person, response);
    }

    @PostMapping("")
    public ResponseEntity<Person> saveOrUpdate(@RequestBody PersonDTO personDTO) {
        Person responseBody = personService.saveOrUpdate(personDTO);
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        personService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        personService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable long id) {
        Person responseBody = personService.findById(id);
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("")
    public ResponseEntity<List<Person>> findAll() {
        List<Person> responseBody = personService.findAll();
        return ResponseEntity.ok(responseBody);
    }


}
