package ir.mapsa.jlottery.jlottery.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class LotteryDTO {

    private WinnerDTO winner;
    private Date date;

}
