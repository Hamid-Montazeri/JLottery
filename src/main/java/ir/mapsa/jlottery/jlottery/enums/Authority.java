package ir.mapsa.jlottery.jlottery.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {

    ACCESS_ADMIN,
    NEW_USER,
    EDIT_USER,
    DELETE_USER,
    ACCESS_USER;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
