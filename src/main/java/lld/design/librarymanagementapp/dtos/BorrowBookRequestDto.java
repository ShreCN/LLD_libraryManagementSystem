package lld.design.librarymanagementapp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BorrowBookRequestDto {
    private Long bookId;
    private Long memberId;
    private Long librarianId;
}
