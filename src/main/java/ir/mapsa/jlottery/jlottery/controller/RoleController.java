package ir.mapsa.jlottery.jlottery.controller;

import ir.mapsa.jlottery.jlottery.dto.RoleDTO;
import ir.mapsa.jlottery.jlottery.model.Role;
import ir.mapsa.jlottery.jlottery.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final IRoleService roleService;

    @PostMapping
    public ResponseEntity<Role> saveOrUpdate(@RequestBody RoleDTO roleDTO) {
        return ResponseEntity.ok(roleService.saveOrUpdate(roleDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        roleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        roleService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(roleService.findById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<Role>> findAll() {
        return ResponseEntity.ok().body(roleService.findAll());
    }

}
