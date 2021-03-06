package ir.mapsa.jlottery.jlottery.base;

import java.util.List;

public interface BaseMapper<E, D> {

    D toDTO(E entity);

    E toEntity(D dto);

    List<D> toDTOs(List<E> entities);

    List<E> toEntities(List<D> dtos);

}
