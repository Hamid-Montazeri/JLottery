package ir.mapsa.jlottery.jlottery.mapper;

import ir.mapsa.jlottery.jlottery.base.BaseMapper;
import ir.mapsa.jlottery.jlottery.dto.WinnerDTO;
import ir.mapsa.jlottery.jlottery.model.Winner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = PersonMapper.class)
public interface WinnerMapper extends BaseMapper<Winner, WinnerDTO> {
}
