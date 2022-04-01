package ir.mapsa.jlottery.jlottery.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Lottery {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Winner winner;

    @Temporal(TemporalType.DATE)
    private Date date;

}
