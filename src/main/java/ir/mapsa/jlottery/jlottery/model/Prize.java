package ir.mapsa.jlottery.jlottery.model;

import ir.mapsa.jlottery.jlottery.enums.EPrizeType;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
public class Prize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EPrizeType name;

    private Integer stock;

    public Long getId() {
        return this.id;
    }

    public EPrizeType getName() {
        return this.name;
    }

    public Integer getStock() {
        return this.stock;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(EPrizeType name) {
        this.name = name;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize = (Prize) o;
        return name == prize.name;
    }

}
