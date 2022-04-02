package ir.mapsa.jlottery.jlottery.dto;

import java.util.Date;

public class LotteryDTO {

    private WinnerDTO winner;
    private Date date;

    public WinnerDTO getWinner() {
        return this.winner;
    }

    public Date getDate() {
        return this.date;
    }

    public void setWinner(WinnerDTO winner) {
        this.winner = winner;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
