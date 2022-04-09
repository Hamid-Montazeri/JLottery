package ir.mapsa.jlottery.jlottery.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Component
public class Lottery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Winner winner;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Long getId() {
        return this.id;
    }

    public Winner getWinner() {
        return this.winner;
    }

    public Date getDate() {
        return this.date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWinner(Winner winner) {
        this.winner = winner;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
