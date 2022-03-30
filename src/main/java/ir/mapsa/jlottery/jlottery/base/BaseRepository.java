package ir.mapsa.jlottery.jlottery.base;


import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BaseRepository<E> extends PagingAndSortingRepository<E, Long> {

}
