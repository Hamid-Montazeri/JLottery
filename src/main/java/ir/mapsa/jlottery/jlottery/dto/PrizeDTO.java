package ir.mapsa.jlottery.jlottery.dto;

import ir.mapsa.jlottery.jlottery.enums.EPrizeType;


public class PrizeDTO {

    private EPrizeType name;
    private Integer stock;

    public EPrizeType getName() {
        return this.name;
    }

    public Integer getStock() {
        return this.stock;
    }

    public void setName(EPrizeType name) {
        this.name = name;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
