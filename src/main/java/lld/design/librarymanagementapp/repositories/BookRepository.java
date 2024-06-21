package lld.design.librarymanagementapp.repositories;

import lld.design.librarymanagementapp.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public Optional<Book> findById(Long bookId);
}
