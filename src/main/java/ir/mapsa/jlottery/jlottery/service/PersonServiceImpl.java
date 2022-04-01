package ir.mapsa.jlottery.jlottery.service;

import ir.mapsa.jlottery.jlottery.base.BaseMapper;
import ir.mapsa.jlottery.jlottery.base.BaseRepository;
import ir.mapsa.jlottery.jlottery.base.BaseServiceImpl;
import ir.mapsa.jlottery.jlottery.dto.PersonDTO;
import ir.mapsa.jlottery.jlottery.mapper.PersonMapper;
import ir.mapsa.jlottery.jlottery.model.Person;
import ir.mapsa.jlottery.jlottery.respository.PersonRepository;
import ir.mapsa.jlottery.jlottery.util.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl extends BaseServiceImpl<Person, PersonDTO> implements IPersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    protected BaseRepository<Person> getRepository() {
        return personRepository;
    }

    @Override
    protected BaseMapper<Person, PersonDTO> getMapper() {
        return personMapper;
    }

    @Override
    public ResponseEntity<String> generateToken(Person person, HttpServletResponse response) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            person.getUsername(),
                            person.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
        String token = jwtUtil.generateToken(person);

        return ResponseEntity.ok(token);
    }


}
