package ir.mapsa.jlottery.jlottery.mapper;

import ir.mapsa.jlottery.jlottery.base.BaseMapper;
import ir.mapsa.jlottery.jlottery.dto.PersonDTO;
import ir.mapsa.jlottery.jlottery.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {RoleMapper.class, PrizeMapper.class})
public interface PersonMapper extends BaseMapper<Person, PersonDTO> {

}
