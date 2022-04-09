package ir.mapsa.jlottery.jlottery.controller;

import ir.mapsa.jlottery.jlottery.dto.PersonDTO;
import ir.mapsa.jlottery.jlottery.model.Person;
import ir.mapsa.jlottery.jlottery.service.IPersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final IPersonService personService;

    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/generate-token")
    public ResponseEntity<String> generateToken(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
        Optional<Person> optionalPerson = personService.findUserByUsernameAndPassword(username, password);
        return personService.generateToken(optionalPerson.orElseThrow(), response);
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
