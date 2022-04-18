package ir.mapsa.jlottery.jlottery.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LotteryDTO {

    private WinnerDTO winner;
    private Date date;

}
