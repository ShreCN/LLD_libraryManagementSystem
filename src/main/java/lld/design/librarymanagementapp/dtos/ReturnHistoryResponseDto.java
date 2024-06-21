package lld.design.librarymanagementapp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReturnHistoryResponseDto {
    private Long returnHistoryId;

    public ReturnHistoryResponseDto(Long id) {
        this.returnHistoryId = id;
    }
}


