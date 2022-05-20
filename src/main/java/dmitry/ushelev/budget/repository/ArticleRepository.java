package dmitry.ushelev.budget.repository;

import dmitry.ushelev.budget.model.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Optional;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
    @PreAuthorize("hasAuthority('modify')")
    @Override
    <S extends Article> S save(S entity);

    @PreAuthorize("hasAuthority('modify')")
    @Override
    <S extends Article> Iterable<S> saveAll(Iterable<S> entities);

    @PreAuthorize("hasAuthority('modify')")
    @Override
    void deleteById(Integer integer);

    @PreAuthorize("hasAuthority('modify')")
    @Override
    void delete(Article entity);

    @PreAuthorize("hasAuthority('modify')")
    @Override
    void deleteAllById(Iterable<? extends Integer> integers);

    @PreAuthorize("hasAuthority('modify')")
    @Override
    void deleteAll(Iterable<? extends Article> entities);

    @PreAuthorize("hasAuthority('modify')")
    @Override
    void deleteAll();

    @Override
    Optional<Article> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    Iterable<Article> findAll();

    @Override
    Iterable<Article> findAllById(Iterable<Integer> integers);

    @Override
    long count();
}