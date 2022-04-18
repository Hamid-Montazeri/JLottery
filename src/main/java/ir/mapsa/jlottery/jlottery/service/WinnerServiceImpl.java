package ir.mapsa.jlottery.jlottery.service;

import ir.mapsa.jlottery.jlottery.base.BaseMapper;
import ir.mapsa.jlottery.jlottery.base.BaseRepository;
import ir.mapsa.jlottery.jlottery.base.BaseServiceImpl;
import ir.mapsa.jlottery.jlottery.dto.WinnerDTO;
import ir.mapsa.jlottery.jlottery.mapper.WinnerMapper;
import ir.mapsa.jlottery.jlottery.model.Winner;
import ir.mapsa.jlottery.jlottery.respository.WinnerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WinnerServiceImpl extends BaseServiceImpl<Winner, WinnerDTO> implements IWinnerService {

    private final WinnerRepository repository;
    private final WinnerMapper mapper;

    @Override
    protected BaseRepository<Winner> getRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<Winner, WinnerDTO> getMapper() {
        return mapper;
    }
}
