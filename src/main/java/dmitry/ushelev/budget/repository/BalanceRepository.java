package dmitry.ushelev.budget.repository;

import dmitry.ushelev.budget.model.Balance;
import dmitry.ushelev.budget.model.Operation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;

import java.math.BigDecimal;
import java.util.List;

public interface BalanceRepository extends CrudRepository<Balance, Integer> {
    @PreAuthorize("hasAuthority('modify')")
    @Override
    <S extends Balance> S save(S entity);

    @PreAuthorize("hasAuthority('modify')")
    @Override
    <S extends Balance> Iterable<S> saveAll(Iterable<S> entities);

    @PreAuthorize("hasAuthority('modify')")
    @Override
    void deleteById(Integer integer);

    @PreAuthorize("hasAuthority('modify')")
    @Override
    void delete(Balance entity);

    @PreAuthorize("hasAuthority('modify')")
    @Override
    void deleteAllById(Iterable<? extends Integer> integers);

    @PreAuthorize("hasAuthority('modify')")
    @Override
    void deleteAll(Iterable<? extends Balance> entities);

    @PreAuthorize("hasAuthority('modify')")
    @Override
    void deleteAll();
}