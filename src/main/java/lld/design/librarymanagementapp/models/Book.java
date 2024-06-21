package lld.design.librarymanagementapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Book extends BaseModel{
    private String ISBN;
    private String title;
    private String author;
    private Integer publishedYear;
    @Enumerated
    private AvailabilityStatus availabilityStatus;

    @OneToMany(mappedBy = "book")
    private List<BorrowHistory> borrowHistories;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private LibraryManager libraryManager;
}
