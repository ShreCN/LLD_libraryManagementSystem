package lld.design.librarymanagementapp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BorrowBookResponseDto {
    private Long borrowHistoryId;

    public BorrowBookResponseDto(Long id){
        this.borrowHistoryId = id;
    }
}
