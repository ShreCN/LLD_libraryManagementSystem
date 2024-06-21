package lld.design.librarymanagementapp.controllers;

import lld.design.librarymanagementapp.dtos.BorrowBookRequestDto;
import lld.design.librarymanagementapp.dtos.BorrowBookResponseDto;
import lld.design.librarymanagementapp.dtos.ReturnHistoryRequestDto;
import lld.design.librarymanagementapp.dtos.ReturnHistoryResponseDto;
import lld.design.librarymanagementapp.models.Book;
import lld.design.librarymanagementapp.models.BorrowHistory;
import lld.design.librarymanagementapp.models.ReturnHistory;
import lld.design.librarymanagementapp.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/borrow")
    public BorrowBookResponseDto borrowBook(@RequestBody BorrowBookRequestDto borrowBookrequestDto){
        BorrowHistory borrowHistory = bookService.borrowBook(borrowBookrequestDto.getBookId(),
                borrowBookrequestDto.getMemberId(),
                borrowBookrequestDto.getLibrarianId());
        return new BorrowBookResponseDto(borrowHistory.getId());
    }

    @GetMapping("/return")
    public ReturnHistoryResponseDto returnBook(@RequestBody ReturnHistoryRequestDto returnHistoryRequestDto){
        ReturnHistory returnHistory =
                bookService.returnBook(returnHistoryRequestDto.getBorrowHistoryId(),
                        returnHistoryRequestDto.getLibrarianId());
        return new ReturnHistoryResponseDto(returnHistory.getId());
    }
}
