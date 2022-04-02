package ir.mapsa.jlottery.jlottery.dto;

import ir.mapsa.jlottery.jlottery.enums.Authority;
import ir.mapsa.jlottery.jlottery.enums.ERole;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class RoleDTO {

    private ERole name;
    private List<Authority> authorities;

}
