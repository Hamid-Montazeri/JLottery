package ir.mapsa.jlottery.jlottery.service;

import ir.mapsa.jlottery.jlottery.base.BaseMapper;
import ir.mapsa.jlottery.jlottery.base.BaseRepository;
import ir.mapsa.jlottery.jlottery.base.BaseServiceImpl;
import ir.mapsa.jlottery.jlottery.dto.RoleDTO;
import ir.mapsa.jlottery.jlottery.mapper.RoleMapper;
import ir.mapsa.jlottery.jlottery.model.Role;
import ir.mapsa.jlottery.jlottery.respository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleDTO> implements IRoleService{

    private final RoleRepository repository;
    private final RoleMapper mapper;

    @Autowired
    public RoleServiceImpl(RoleRepository repository, RoleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected BaseRepository<Role> getLotteryRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<Role, RoleDTO> getMapper() {
        return mapper;
    }

}
