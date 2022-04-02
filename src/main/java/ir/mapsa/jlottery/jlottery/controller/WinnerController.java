package ir.mapsa.jlottery.jlottery.controller;

import ir.mapsa.jlottery.jlottery.model.Winner;
import ir.mapsa.jlottery.jlottery.service.IWinnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/winners")
@RequiredArgsConstructor
public class WinnerController {

    private final IWinnerService winnerService;
/*
    @PostMapping
    public ResponseEntity<Winner> saveOrUpdate(@RequestBody WinnerDTO winnerDTO) {
        return ResponseEntity.ok().body(winnerService.saveOrUpdate(winnerDTO));
    }
*/

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
        Winner responseBody = winnerService.findById(id);
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("")
    public ResponseEntity<List<Winner>> findAll() {
        List<Winner> responseBody = winnerService.findAll();
        return ResponseEntity.ok(responseBody);
    }

}
