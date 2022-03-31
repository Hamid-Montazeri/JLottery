package ir.mapsa.jlottery.jlottery.service;

import ir.mapsa.jlottery.jlottery.base.BaseMapper;
import ir.mapsa.jlottery.jlottery.base.BaseRepository;
import ir.mapsa.jlottery.jlottery.base.BaseServiceImpl;
import ir.mapsa.jlottery.jlottery.dto.LotteryDTO;
import ir.mapsa.jlottery.jlottery.enums.EPrizeType;
import ir.mapsa.jlottery.jlottery.mapper.LotteryMapper;
import ir.mapsa.jlottery.jlottery.model.Lottery;
import ir.mapsa.jlottery.jlottery.model.Person;
import ir.mapsa.jlottery.jlottery.model.Prize;
import ir.mapsa.jlottery.jlottery.model.Winner;
import ir.mapsa.jlottery.jlottery.respository.LotteryRepository;
import ir.mapsa.jlottery.jlottery.respository.PersonRepository;
import org.hibernate.type.LocalDateTimeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class LotteryServiceImpl extends BaseServiceImpl<Lottery, LotteryDTO> implements ILotteryService {

    private final LotteryRepository lotteryRepository;
    private final PersonRepository personRepository;
    private final LotteryMapper lotteryMapper;

    @Autowired
    public LotteryServiceImpl(LotteryRepository lotteryRepository, PersonRepository personRepository, LotteryMapper lotteryMapper) {
        this.lotteryRepository = lotteryRepository;
        this.personRepository = personRepository;
        this.lotteryMapper = lotteryMapper;
    }

    @Override
    protected BaseRepository<Lottery> getLotteryRepository() {
        return lotteryRepository;
    }

    @Override
    protected BaseMapper<Lottery, LotteryDTO> getMapper() {
        return lotteryMapper;
    }

    @Override
    public LotteryDTO execute(EPrizeType prizeType, Integer prizeCount, Integer minRequiredScore) {
        Set<Person> eligiblePersons = personRepository.findAllByScoreBetween(minRequiredScore, Integer.MAX_VALUE);
        int randomBall = new Random().nextInt(0, eligiblePersons.size() + 1);

        Person winnerPerson = (Person) eligiblePersons.toArray()[randomBall];

        System.out.println(winnerPerson.toString());

        Prize prize = new Prize();
        prize.setStock(prizeCount - 1);
        prize.setName(prizeType);

        winnerPerson.setPrizes(List.of(prize));
        Winner winner = new Winner();
        winner.setPerson(winnerPerson);

        Lottery lottery = new Lottery();
        lottery.setWinner(winner);
        lottery.setDate(new Date());

        lotteryRepository.save(lottery);

        return lotteryMapper.toDTO(lottery);
    }
}
