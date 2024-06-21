package lld.design.librarymanagementapp.repositories;

import lld.design.librarymanagementapp.models.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LibrarianRepository  extends JpaRepository<Librarian, Long> {
    public Optional<Librarian> findById(Long librarianId);
}
