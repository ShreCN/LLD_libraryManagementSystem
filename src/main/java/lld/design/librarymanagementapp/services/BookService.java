package lld.design.librarymanagementapp.services;

import lld.design.librarymanagementapp.exceptions.InvalidInput;
import lld.design.librarymanagementapp.models.*;
import lld.design.librarymanagementapp.repositories.BookRepository;
import lld.design.librarymanagementapp.repositories.BorrowHistoryRepository;
import lld.design.librarymanagementapp.repositories.LibrarianRepository;
import lld.design.librarymanagementapp.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;
    private MemberRepository memberRepository;
    private LibrarianRepository librarianRepository;
    private BorrowHistoryRepository borrowHistoryRepository;
    public BookService(BookRepository bookRepository,
                       MemberRepository memberRepository,
                       LibrarianRepository librarianRepository,
                       BorrowHistoryRepository borrowHistoryRepository){
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        this.librarianRepository = librarianRepository;
        this.borrowHistoryRepository = borrowHistoryRepository;
    }
    public BorrowHistory borrowBook(Long bookId, Long memberId, Long librarianId) {
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isEmpty()){
            throw new InvalidInput("Enter valid Book Id");
        }
        Optional<Member> member = memberRepository.findById(memberId);
        if(member.isEmpty()){
            throw new InvalidInput("Enter valid Member Id");
        }
        Optional<Librarian> librarian = librarianRepository.findById(librarianId);
        if(librarian.isEmpty()){
            throw new InvalidInput("Enter valid Librarian Id");
        }
        BorrowHistory borrowHistory = new BorrowHistory().builder()
                                                .book(book.get())
                                                .member(member.get())
                                                .librarian(librarian.get()).build();
        return borrowHistoryRepository.save(borrowHistory);
    }

    public ReturnHistory returnBook(Long borrowHistoryId, Long librarianId) {
        Optional<BorrowHistory> borrowHistory = borrowHistoryRepository.findById(borrowHistoryId);
        if(borrowHistory.isEmpty()){
            throw new InvalidInput("Enter valid BorrowHistory Id");
        }
        Optional<Librarian> librarian = librarianRepository.findById(librarianId);
        if(librarian.isEmpty()){
            throw new InvalidInput("Enter valid Librarian Id");
        }
        ReturnHistory returnHistory = new ReturnHistory().builder()
                                            .librarian(librarian.get()).build();
        borrowHistory.get().setReturnHistory(returnHistory);

        // check for penalty
        LocalDate borrowedDate = convertToLocalDate(borrowHistory.get().getBorrowedDate());
        LocalDate returnedDate = convertToLocalDate(returnHistory.getReturnedDate());
        long daysBetween = ChronoUnit.DAYS.between(borrowedDate, returnedDate);

        if(daysBetween > LibraryManager.loan_duration){
            Penalty penalty = new Penalty().builder()
                                    .member(borrowHistory.get().getMember())
                                    .borrowHistory(borrowHistory.get())
                                    .amountToBePaid(calculatePenaltyAmount(daysBetween))
                                    .status(PaymentStatus.UNPAID).build();
            borrowHistory.get().setPenalty(penalty);
        }

        borrowHistoryRepository.save(borrowHistory.get());
        return  returnHistory;
    }

    private LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private double calculatePenaltyAmount(long days){
        return days * 100;
    }
}
