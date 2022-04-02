package ir.mapsa.jlottery.jlottery.dto;

import ir.mapsa.jlottery.jlottery.enums.EPrizeType;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class PrizeDTO {

    private EPrizeType name;
    private Integer stock;

}
