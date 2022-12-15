package ir.mapsa.jlottery.jlottery.util;

import com.github.javafaker.Faker;
import ir.mapsa.jlottery.jlottery.enums.Authority;
import ir.mapsa.jlottery.jlottery.enums.ERole;
import ir.mapsa.jlottery.jlottery.model.Person;
import ir.mapsa.jlottery.jlottery.model.Role;
import ir.mapsa.jlottery.jlottery.respository.PersonRepository;
import ir.mapsa.jlottery.jlottery.respository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
@AllArgsConstructor
public class UserSeeder implements ApplicationRunner {

    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;

    @Override
    public void run(ApplicationArguments args) {
        if (roleRepository.count() == 0) {
            insertRoles();
        }
        if (personRepository.count() == 0) {
            insertUsers();
        }
    }

    private void insertRoles() {
        Role userRole = new Role();
        userRole.setName(ERole.USER);
        List<Authority> userAuthorities = new ArrayList<>();
        userAuthorities.add(Authority.ACCESS_USER);
        userRole.setAuthorities(userAuthorities);
        roleRepository.save(userRole);

        Role adminRole = new Role();
        adminRole.setName(ERole.ADMIN);

        List<Authority> adminAuthorities = new ArrayList<>();
        adminAuthorities.add(Authority.NEW_USER);
        adminAuthorities.add(Authority.EDIT_USER);
        adminAuthorities.add(Authority.DELETE_USER);
        adminAuthorities.add(Authority.ACCESS_ADMIN);
        adminRole.setAuthorities(adminAuthorities);

        roleRepository.save(adminRole);

    }

    private void insertUsers() {
        for (int i = 0; i < 10; i++) {
            Faker faker = new Faker();

            Person person = new Person();
            person.setFullName(faker.name().fullName());
            person.setUsername(faker.name().username());
            person.setPassword(faker.internet().password(true));

            int randomScore = new Random().nextInt(1, 2001);
            person.setScore(randomScore);

            Set<Role> userRoles = new HashSet<>();
            Role userRole = roleRepository.findByName(ERole.USER);
            userRoles.add(userRole);
            person.setRoles(userRoles);

            personRepository.save(person);
        }
    }

}
