package ir.mapsa.jlottery.jlottery.service;

import ir.mapsa.jlottery.jlottery.base.BaseMapper;
import ir.mapsa.jlottery.jlottery.base.BaseRepository;
import ir.mapsa.jlottery.jlottery.base.BaseServiceImpl;
import ir.mapsa.jlottery.jlottery.dto.PrizeDTO;
import ir.mapsa.jlottery.jlottery.mapper.PrizeMapper;
import ir.mapsa.jlottery.jlottery.model.Prize;
import ir.mapsa.jlottery.jlottery.respository.PrizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrizeServiceImpl extends BaseServiceImpl<Prize, PrizeDTO> implements IPrizeService {

    private final PrizeRepository repository;
    private final PrizeMapper mapper;

    @Autowired
    public PrizeServiceImpl(PrizeRepository repository, PrizeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected BaseRepository<Prize> getLotteryRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<Prize, PrizeDTO> getMapper() {
        return mapper;
    }
}
