package lld.design.librarymanagementapp.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Penalty extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne
    private BorrowHistory borrowHistory;

    private Double amountToBePaid;

    @Enumerated
    private PaymentStatus status;
}
