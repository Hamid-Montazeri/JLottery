package ir.mapsa.jlottery.jlottery.dto;

import ir.mapsa.jlottery.jlottery.enums.Authority;
import ir.mapsa.jlottery.jlottery.enums.ERole;

import java.util.List;


public class RoleDTO {

    private ERole name;
    private List<Authority> authorities;

    public ERole getName() {
        return this.name;
    }

    public List<Authority> getAuthorities() {
        return this.authorities;
    }

    public void setName(ERole name) {
        this.name = name;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
