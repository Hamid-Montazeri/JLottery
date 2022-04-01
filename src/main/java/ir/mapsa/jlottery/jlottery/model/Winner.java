package ir.mapsa.jlottery.jlottery.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Winner {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;
}
