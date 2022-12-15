package ir.mapsa.jlottery.jlottery.respository;

import ir.mapsa.jlottery.jlottery.base.BaseRepository;
import ir.mapsa.jlottery.jlottery.enums.Authority;
import ir.mapsa.jlottery.jlottery.enums.ERole;
import ir.mapsa.jlottery.jlottery.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends BaseRepository<Role> {

    Role findByName(ERole name);

//    Role findAllByAuthoritiesIn(List<Authority> authorities);

}
