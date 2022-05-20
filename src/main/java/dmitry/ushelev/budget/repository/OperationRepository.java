package dmitry.ushelev.budget.repository;

import dmitry.ushelev.budget.model.Operation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;

public interface OperationRepository extends CrudRepository<Operation, Integer> {
    @PreAuthorize("hasAuthority('modify')")
    @Override
    <S extends Operation> S save(S entity);

    @PreAuthorize("hasAuthority('modify')")
    @Override
    <S extends Operation> Iterable<S> saveAll(Iterable<S> entities);

    @PreAuthorize("hasAuthority('modify')")
    @Override
    void deleteById(Integer integer);

    @PreAuthorize("hasAuthority('modify')")
    @Override
    void delete(Operation entity);

    @PreAuthorize("hasAuthority('modify')")
    @Override
    void deleteAllById(Iterable<? extends Integer> integers);

    @PreAuthorize("hasAuthority('modify')")
    @Override
    void deleteAll(Iterable<? extends Operation> entities);

    @PreAuthorize("hasAuthority('modify')")
    @Override
    void deleteAll();
}