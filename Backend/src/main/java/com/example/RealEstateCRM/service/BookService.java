package com.example.RealEstateCRM.service;

import com.example.RealEstateCRM.model.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookService {
    BookList addBookList(BookList bookList);

    List<BookList> bookListDetails();

    BookList getBookListById(Long bookListId);

    BookList updateBookList(Long bookListId, BookList bookList);

    BookRef addBookRef(BookRef bookRef);

    List<BookRef> bookRefDetails();

    BookRef getBookRefById(Long bookRefId);

    BookRef updateBookRef(Long bookRefId, BookRef bookRef);

    BookPay addBookPay(BookPay bookPay);

    List<BookPay> bookPayDetails();

    BookPay getBookPayById(Long bookPayId);

    BookPay updateBookPay(Long bookPayId, BookPay bookPay);

    BookChange addBookChange(BookChange bookChange);

    List<BookChange> BookChangeDetails();

    BookChange getBookChangeById(Long bookChangeId);

    BookChange updateBookChange(Long bookChangeId, BookChange bookChange);

    Booking addBooking(Booking booking);

    BookCancel addBookCancel(BookCancel bookCancel);

    List<BookCancel> BookCancelDetails();
    List<Booking> getAllBookingDetails();
    Booking getBookingDetailsById(Long bookingId);
//book Confirm page
BookConfirm addBookConfirm(BookConfirm bookConfirm, MultipartFile legalDocument, MultipartFile agreementDocument, MultipartFile idProofDocument);
    List<BookConfirm> getAllBookConfirmDetails ();
    String deleteBookingConfirmById(Long bookingConfirmId);
    BookConfirm getBookConfirmById(Long bookConfirmId);

    Booking getBookListByCustomerId(Long customerId);
    String deleteBookingById(Long bookingId);
    Booking updateBookPayment(Long bookingId,Double paymentAmount,Double balance);

    BookPay addNewPayment(BookPay bookPay);
    Booking getBookingDetailsByBlockId(String blockId);


    List<BookPay> getAllBookPayDetailsByBookingId(Long bookingId);

    List<Booking> getBookingByCompanyId(Long companyId);

    List<Booking> getBookingByCompanyIdAndTeamId(Long companyId, List<Long> teamId);

    List<Booking> getBookingByCompanyIdAndBalance(Long companyId);

    List<Booking> getBookingByCompanyIdAndTeamIdAndBalance(Long companyId, List<Long> teamId);

    List<BookConfirm> getBookConfirmByCompanyId(Long companyId);

    List<BookConfirm> getBookConfirmByCompanyIdAndTeamId(Long companyId, List<Long> teamId);

    List<BookCancel> getBookCancelByCompanyId(Long companyId);

    List<BookCancel> getBookCancelByCompanyIdAndTeamId(Long companyId, List<Long> teamId);

    List<Booking> getBookingByCompanyIdAndNonZeroBalance(Long companyId);

    List<Booking> getBookingByCompanyIdAndTeamIdAndNonZeroBalance(Long companyId, List<Long> teamId);
}






