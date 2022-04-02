package ir.mapsa.jlottery.jlottery.model;

import ir.mapsa.jlottery.jlottery.enums.Authority;
import ir.mapsa.jlottery.jlottery.enums.ERole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ERole name;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Authority.class, fetch = FetchType.EAGER)
    private List<Authority> authorities;

}
