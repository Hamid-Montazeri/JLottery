package ir.mapsa.jlottery.jlottery.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
public class Winner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    public Long getId() {
        return this.id;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
