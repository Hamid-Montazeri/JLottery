package ir.mapsa.jlottery.jlottery.mapper;

import ir.mapsa.jlottery.jlottery.base.BaseMapper;
import ir.mapsa.jlottery.jlottery.dto.LotteryDTO;
import ir.mapsa.jlottery.jlottery.model.Lottery;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LotteryMapper extends BaseMapper<Lottery, LotteryDTO> {

}
