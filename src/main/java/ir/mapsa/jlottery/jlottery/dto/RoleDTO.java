package ir.mapsa.jlottery.jlottery.dto;

import ir.mapsa.jlottery.jlottery.enums.Authority;
import ir.mapsa.jlottery.jlottery.enums.ERole;
import lombok.Data;

import java.util.List;

@Data
public class RoleDTO {

    private ERole name;
    private List<Authority> authorities;

}
