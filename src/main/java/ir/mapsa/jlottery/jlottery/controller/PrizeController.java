package ir.mapsa.jlottery.jlottery.controller;

import ir.mapsa.jlottery.jlottery.dto.PrizeDTO;
import ir.mapsa.jlottery.jlottery.model.Prize;
import ir.mapsa.jlottery.jlottery.service.IPrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prizes")
public class PrizeController {

    private final IPrizeService prizeService;

    @Autowired
    public PrizeController(IPrizeService prizeService) {
        this.prizeService = prizeService;
    }

    @PostMapping
    public ResponseEntity<Prize> saveOrUpdate(@RequestBody PrizeDTO prizeDTO) {
        return ResponseEntity.ok().body(prizeService.saveOrUpdate(prizeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        prizeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        prizeService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prize> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(prizeService.findById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<Prize>> findAll() {
        return ResponseEntity.ok().body(prizeService.findAll());
    }

}