package ir.mapsa.jlottery.jlottery.base;

import java.util.List;

public interface BaseService<E, D> {

    E saveOrUpdate(D dto);

    void delete(E entity);

    void deleteById(long id);

    void deleteAll();

    E findById(long id);

    List<E> findAll();

}
