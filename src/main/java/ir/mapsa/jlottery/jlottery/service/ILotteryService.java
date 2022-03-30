package ir.mapsa.jlottery.jlottery.service;

import ir.mapsa.jlottery.jlottery.base.BaseService;
import ir.mapsa.jlottery.jlottery.dto.LotteryDTO;
import ir.mapsa.jlottery.jlottery.enums.EPrizeLevel;
import ir.mapsa.jlottery.jlottery.enums.EPrizeType;
import ir.mapsa.jlottery.jlottery.model.Lottery;

public interface ILotteryService extends BaseService<Lottery, LotteryDTO> {

    LotteryDTO execute(EPrizeType prizeType, Integer prizeCount, Integer minRequiredScore);

}
