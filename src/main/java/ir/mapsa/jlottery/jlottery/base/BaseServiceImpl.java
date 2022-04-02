package ir.mapsa.jlottery.jlottery.base;

import java.util.List;

public abstract class BaseServiceImpl<E, D> implements BaseService<E, D> {

    protected abstract BaseRepository<E> getRepository();

    protected abstract BaseMapper<E, D> getMapper();

    @Override
    public E saveOrUpdate(D dto) {
        return getRepository().save(getMapper().toEntity(dto));
    }

    @Override
    public void delete(E entity) {
        getRepository().delete(entity);
    }

    @Override
    public void deleteById(long id) {
        getRepository().deleteById(id);
    }

    @Override
    public void deleteAll() {
        getRepository().deleteAll();
    }

    @Override
    public E findById(long id) {
        return getRepository().findById(id).orElseThrow();
    }

    @Override
    public List<E> findAll() {
        return (List<E>) getRepository().findAll();
    }
}
