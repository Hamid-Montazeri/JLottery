package ir.mapsa.jlottery.jlottery.mapper;

import ir.mapsa.jlottery.jlottery.base.BaseMapper;
import ir.mapsa.jlottery.jlottery.dto.PrizeDTO;
import ir.mapsa.jlottery.jlottery.model.Prize;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PrizeMapper extends BaseMapper<Prize, PrizeDTO> {

}
