package ir.mapsa.jlottery.jlottery.controller;

import ir.mapsa.jlottery.jlottery.dto.WinnerDTO;
import ir.mapsa.jlottery.jlottery.model.Winner;
import ir.mapsa.jlottery.jlottery.service.IWinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/winners")
public class WinnerController {

    private final IWinnerService winnerService;

    @Autowired
    public WinnerController(IWinnerService winnerService) {
        this.winnerService = winnerService;
    }

    @PostMapping
    public ResponseEntity<Winner> saveOrUpdate(@RequestBody WinnerDTO winnerDTO) {
        return ResponseEntity.ok().body(winnerService.saveOrUpdate(winnerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        winnerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        winnerService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Winner> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(winnerService.findById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<Winner>> findAll() {
        return ResponseEntity.ok().body(winnerService.findAll());
    }

}
