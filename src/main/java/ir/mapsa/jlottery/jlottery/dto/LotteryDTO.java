package ir.mapsa.jlottery.jlottery.dto;

import ir.mapsa.jlottery.jlottery.model.Winner;

import java.util.Date;

public class LotteryDTO {

    private Winner winner;

    private Date date;

    public Winner getWinner() {
        return winner;
    }

    public void setWinner(Winner winner) {
        this.winner = winner;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
