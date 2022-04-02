package ir.mapsa.jlottery.jlottery.controller;

import ir.mapsa.jlottery.jlottery.dto.LotteryDTO;
import ir.mapsa.jlottery.jlottery.enums.EPrizeType;
import ir.mapsa.jlottery.jlottery.model.Lottery;
import ir.mapsa.jlottery.jlottery.service.ILotteryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lotteries")
public class LotteryController {

    private final ILotteryService lotteryService;

    public LotteryController(ILotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }

    @GetMapping("/execute")
    public ResponseEntity<?> executeLottery(@RequestParam EPrizeType prizeType, @RequestParam Integer minRequiredScore) {
        return lotteryService.execute(prizeType, minRequiredScore);
    }

    @PostMapping("")
    public ResponseEntity<Lottery> saveOrUpdate(@RequestBody LotteryDTO lotteryDTO) {
        Lottery responseBody = lotteryService.saveOrUpdate(lotteryDTO);
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        lotteryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        lotteryService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lottery> findById(@PathVariable long id) {
        Lottery responseBody = lotteryService.findById(id);
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("")
    public ResponseEntity<List<Lottery>> findAll() {
        List<Lottery> responseBody = lotteryService.findAll();
        return ResponseEntity.ok(responseBody);
    }

}
