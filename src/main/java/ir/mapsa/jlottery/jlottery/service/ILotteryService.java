package ir.mapsa.jlottery.jlottery.service;

import ir.mapsa.jlottery.jlottery.base.BaseService;
import ir.mapsa.jlottery.jlottery.dto.LotteryDTO;
import ir.mapsa.jlottery.jlottery.enums.EPrizeType;
import ir.mapsa.jlottery.jlottery.model.Lottery;
import org.springframework.http.ResponseEntity;

public interface ILotteryService extends BaseService<Lottery, LotteryDTO> {

    ResponseEntity<LotteryDTO> execute(EPrizeType prizeType, Integer minRequiredScore);

}
