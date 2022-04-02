package ir.mapsa.jlottery.jlottery.mapper;

import ir.mapsa.jlottery.jlottery.base.BaseMapper;
import ir.mapsa.jlottery.jlottery.dto.RoleDTO;
import ir.mapsa.jlottery.jlottery.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring")
public interface RoleMapper extends BaseMapper<Role, RoleDTO> {

}
