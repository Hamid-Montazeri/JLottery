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
import ir.mapsa.jlottery.jlottery.respository.PrizeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Random;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class LotteryServiceImpl extends BaseServiceImpl<Lottery, LotteryDTO> implements ILotteryService {

    private final LotteryRepository lotteryRepository;
    private final PrizeRepository prizeRepository;
    private final PersonRepository personRepository;
    private final LotteryMapper lotteryMapper;

    private final Prize prize;
    private final Winner winner;
    private final Lottery lottery;

    @Override
    protected BaseRepository<Lottery> getRepository() {
        return lotteryRepository;
    }

    @Override
    protected BaseMapper<Lottery, LotteryDTO> getMapper() {
        return lotteryMapper;
    }

    @Override
    public LotteryDTO execute(EPrizeType prizeType, Integer minRequiredScore) {
        Set<Person> eligiblePersons = personRepository.findAllByScoreBetween(minRequiredScore, Integer.MAX_VALUE);
        int randomBall = new Random().nextInt(0, eligiblePersons.size() + 1);

        System.out.println("random ball = " + randomBall);

        Person winnerPerson = (Person) eligiblePersons.toArray()[randomBall];

        prize.setStock(prize.getStock() - 1);
        prize.setName(prizeType);

        winnerPerson.setPrizes(List.of(prize));

        winner.setPerson(winnerPerson);

        lottery.setWinner(winner);

        lottery.setDate(
                Timestamp.from(Instant.now())
        );

        personRepository.save(winnerPerson);
        prizeRepository.save(prize);
        lotteryRepository.save(lottery);

        return lotteryMapper.toDTO(lottery);
    }
}
