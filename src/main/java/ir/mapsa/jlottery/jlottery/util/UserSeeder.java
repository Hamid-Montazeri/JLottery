package ir.mapsa.jlottery.jlottery.util;

import com.github.javafaker.Faker;
import ir.mapsa.jlottery.jlottery.enums.Authority;
import ir.mapsa.jlottery.jlottery.enums.ERole;
import ir.mapsa.jlottery.jlottery.model.Person;
import ir.mapsa.jlottery.jlottery.model.Role;
import ir.mapsa.jlottery.jlottery.respository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


@Component
public class UserSeeder implements ApplicationRunner {

    private final PersonRepository personRepository;

    @Autowired
    public UserSeeder(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        if (personRepository.count() == 0) {
            for (int i = 0; i < 10; i++) {
                Faker faker = new Faker();

                Person person = new Person();
                person.setFullName(faker.name().fullName());
                person.setUsername(faker.name().username());
                person.setPassword(faker.internet().password(true));

                int randomScore = new Random().nextInt(1, 2001);
                person.setScore(randomScore);

                Set<Role> roles = new HashSet<>();
                Role role = new Role();
                role.setName(ERole.USER);
                role.setAuthorities(List.of(Authority.OP_ACCESS_USER));
                roles.add(role);
                person.setRoles(roles);

                personRepository.save(person);
            }
        }
    }
}
