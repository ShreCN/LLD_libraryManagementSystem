package lld.design.librarymanagementapp.repositories;

import lld.design.librarymanagementapp.models.BorrowHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BorrowHistoryRepository extends JpaRepository<BorrowHistory, Long> {
    public Optional<BorrowHistory> findById(Long borrowHistoryId);

    public BorrowHistory save(BorrowHistory borrowHistory);
}
