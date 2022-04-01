package ir.mapsa.jlottery.jlottery.dto;

import ir.mapsa.jlottery.jlottery.model.Winner;
import lombok.Data;

import java.util.Date;

@Data
public class LotteryDTO {

    private Winner winner;
    private Date date;

}
