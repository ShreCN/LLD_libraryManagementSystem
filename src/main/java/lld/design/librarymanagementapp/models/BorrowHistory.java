package lld.design.librarymanagementapp.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BorrowHistory extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "librarian_id")
    private Librarian librarian;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date borrowedDate;

    @OneToOne
    private ReturnHistory returnHistory;

    @OneToOne
    private Penalty penalty;
}
