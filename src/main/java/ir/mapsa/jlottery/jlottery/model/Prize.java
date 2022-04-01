package ir.mapsa.jlottery.jlottery.model;

import ir.mapsa.jlottery.jlottery.enums.EPrizeType;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@Component
public class Prize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EPrizeType name;

    private Integer stock;

}
