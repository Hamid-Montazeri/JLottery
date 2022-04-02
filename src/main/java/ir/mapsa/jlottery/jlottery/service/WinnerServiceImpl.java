package ir.mapsa.jlottery.jlottery.service;

import ir.mapsa.jlottery.jlottery.base.BaseMapper;
import ir.mapsa.jlottery.jlottery.base.BaseRepository;
import ir.mapsa.jlottery.jlottery.base.BaseServiceImpl;
import ir.mapsa.jlottery.jlottery.dto.WinnerDTO;
import ir.mapsa.jlottery.jlottery.mapper.WinnerMapper;
import ir.mapsa.jlottery.jlottery.model.Winner;
import ir.mapsa.jlottery.jlottery.respository.WinnerRepository;
import org.springframework.stereotype.Service;

@Service
public class WinnerServiceImpl extends BaseServiceImpl<Winner, WinnerDTO> implements IWinnerService {

    private final WinnerRepository repository;
    private final WinnerMapper mapper;

    public WinnerServiceImpl(WinnerRepository repository, WinnerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected BaseRepository<Winner> getRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<Winner, WinnerDTO> getMapper() {
        return mapper;
    }
}
