package lld.design.librarymanagementapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class LibraryManager extends BaseModel{
    private String address;

    @OneToMany(mappedBy = "libraryManager")
    private List<Book> books;

    @OneToMany(mappedBy = "libraryManager")
    private List<Member> members;

    @OneToMany(mappedBy = "libraryManager")
    private List<Librarian> librarians;

    public static final Integer max_books_per_member = 5;
    public static final Integer loan_duration = 14;
}
