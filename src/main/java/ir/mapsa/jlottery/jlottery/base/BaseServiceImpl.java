package ir.mapsa.jlottery.jlottery.base;

import java.util.List;

public abstract class BaseServiceImpl<E, D> implements BaseService<E, D>{

    protected abstract BaseRepository<E> getLotteryRepository();
    protected abstract BaseMapper<E, D> getMapper();

    @Override
    public E saveOrUpdate(D dto) {
        return getLotteryRepository().save(getMapper().toEntity(dto));
    }

    @Override
    public void delete(E entity) {
        getLotteryRepository().delete(entity);
    }

    @Override
    public void deleteById(long id) {
        getLotteryRepository().deleteById(id);
    }

    @Override
    public void deleteAll() {
        getLotteryRepository().deleteAll();
    }

    @Override
    public E findById(long id) {
        return getLotteryRepository().findById(id).orElseThrow();
    }

    @Override
    public List<E> findAll() {
        return (List<E>) getLotteryRepository().findAll();
    }

}
