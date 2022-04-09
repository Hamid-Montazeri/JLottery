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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class LotteryServiceImpl extends BaseServiceImpl<Lottery, LotteryDTO> implements ILotteryService {

    private final LotteryRepository lotteryRepository;
    private final PrizeRepository prizeRepository;
    private final PersonRepository personRepository;
    private final LotteryMapper lotteryMapper;

    private Prize prize;
    private final Winner winner;
    private final Lottery lottery;

    public LotteryServiceImpl(LotteryRepository lotteryRepository, PrizeRepository prizeRepository, PersonRepository personRepository, LotteryMapper lotteryMapper, Prize prize, Winner winner, Lottery lottery) {
        this.lotteryRepository = lotteryRepository;
        this.prizeRepository = prizeRepository;
        this.personRepository = personRepository;
        this.lotteryMapper = lotteryMapper;
        this.prize = prize;
        this.winner = winner;
        this.lottery = lottery;
    }

    @Override
    protected BaseRepository<Lottery> getRepository() {
        return lotteryRepository;
    }

    @Override
    protected BaseMapper<Lottery, LotteryDTO> getMapper() {
        return lotteryMapper;
    }

    @Override
    public ResponseEntity<?> execute(EPrizeType prizeType, Integer minRequiredScore) {

        if (prizeRepository.count() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is no \"prizes!\", first define some \"prizes\", please.");
        }

        prize = prizeRepository.findByName(prizeType);

        if (prize == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    String.format("There is no defined \"%s\"!", prizeType.name())
            );
        }

        Set<Person> eligiblePersons = personRepository.findAllByScoreBetween(minRequiredScore, Integer.MAX_VALUE);

        if (eligiblePersons.size() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not find any eligible customer with required score!");
        }

        int randomBall = new Random().nextInt(0, eligiblePersons.size() + 1);

        Person winnerPerson = (Person) eligiblePersons.toArray()[randomBall];

        if (prize.getStock() >= 1)
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

        LotteryDTO lotteryDTO = lotteryMapper.toDTO(lottery);
        return ResponseEntity.ok(lotteryDTO);
    }
}
