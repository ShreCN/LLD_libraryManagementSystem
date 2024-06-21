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
public class ReturnHistory extends BaseModel{
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date returnedDate;
    @ManyToOne
    @JoinColumn(name = "librarian_id")
    private Librarian librarian;
}
