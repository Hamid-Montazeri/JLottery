package ir.mapsa.jlottery.jlottery.service;

import ir.mapsa.jlottery.jlottery.base.BaseMapper;
import ir.mapsa.jlottery.jlottery.base.BaseRepository;
import ir.mapsa.jlottery.jlottery.base.BaseServiceImpl;
import ir.mapsa.jlottery.jlottery.dto.RoleDTO;
import ir.mapsa.jlottery.jlottery.mapper.RoleMapper;
import ir.mapsa.jlottery.jlottery.model.Role;
import ir.mapsa.jlottery.jlottery.respository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleDTO> implements IRoleService{

    private final RoleRepository repository;
    private final RoleMapper mapper;

    @Override
    protected BaseRepository<Role> getLotteryRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<Role, RoleDTO> getMapper() {
        return mapper;
    }

}
