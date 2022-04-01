package ir.mapsa.jlottery.jlottery.controller;

import ir.mapsa.jlottery.jlottery.dto.LotteryDTO;
import ir.mapsa.jlottery.jlottery.enums.EPrizeType;
import ir.mapsa.jlottery.jlottery.model.Lottery;
import ir.mapsa.jlottery.jlottery.service.ILotteryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lotteries")
@RequiredArgsConstructor
public class LotteryController {

    private final ILotteryService lotteryService;

    @GetMapping("/execute")
    public ResponseEntity<LotteryDTO> executeLottery(@RequestParam EPrizeType prizeType,
                                                     @RequestParam Integer prizeCount,
                                                     @RequestParam Integer minRequiredScore) {
        return ResponseEntity.ok().body(lotteryService.execute(prizeType, prizeCount, minRequiredScore));
    }

    @PostMapping("")
    public ResponseEntity<Lottery> saveOrUpdate(@RequestBody LotteryDTO lotteryDTO) {
        return ResponseEntity.ok().body(lotteryService.saveOrUpdate(lotteryDTO));
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
        return ResponseEntity.ok().body(lotteryService.findById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<Lottery>> findAll() {
        return ResponseEntity.ok().body(lotteryService.findAll());
    }

}
