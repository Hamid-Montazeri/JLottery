package ir.mapsa.jlottery.jlottery.dto;

import ir.mapsa.jlottery.jlottery.enums.EPrizeType;

public class PrizeDTO {

    private EPrizeType name;
    private Integer stock;


    public EPrizeType getName() {
        return name;
    }

    public void setName(EPrizeType name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
