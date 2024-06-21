package lld.design.librarymanagementapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Librarian extends BaseModel{
    private String name;
    private String designation;
    private String phoneNumber;
    @OneToMany(mappedBy = "librarian")
    private List<BorrowHistory> borrowHistories;

    @OneToMany(mappedBy = "librarian")
    private List<ReturnHistory> returnHistories;

    @ManyToOne
    @JoinColumn(name = "librarian_id")
    private LibraryManager libraryManager;
}
