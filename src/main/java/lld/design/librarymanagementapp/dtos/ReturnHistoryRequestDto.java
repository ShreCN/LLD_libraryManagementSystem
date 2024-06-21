package lld.design.librarymanagementapp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReturnHistoryRequestDto {
    private Long borrowHistoryId;
    private Long librarianId;
}
