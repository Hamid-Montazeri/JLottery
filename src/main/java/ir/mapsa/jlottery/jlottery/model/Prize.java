package ir.mapsa.jlottery.jlottery.model;

import ir.mapsa.jlottery.jlottery.enums.EPrizeType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Prize {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private EPrizeType name;

    private Integer stock;

}
