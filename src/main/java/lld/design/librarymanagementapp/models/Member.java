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
public class Member extends BaseModel {
    private String name;

    @OneToMany(mappedBy = "member")
    private List<BorrowHistory> borrowHistories;

    private String phoneNumber;
    private String address;
    private Integer count_of_books_borrowed_currently = 0;

    @OneToMany(mappedBy = "member")
    private List<Penalty> penalties;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private LibraryManager libraryManager;
}
