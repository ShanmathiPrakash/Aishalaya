package com.example.RealEstateCRM.controller;

import com.example.RealEstateCRM.model.*;
import com.example.RealEstateCRM.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookController {
    @Autowired
    BookService bookService;

//    @PreAuthorize("@securityServiceImpl.isAccessible('plotBooking')")
    @PostMapping("/addBooking")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
        return new ResponseEntity<Booking>(bookService.addBooking(booking), HttpStatus.ACCEPTED);
    }

//    @PreAuthorize("@securityServiceImpl.isAccessible('plotBooking')")
    @PostMapping("/addBookList")
    public ResponseEntity<BookList> addBookList(@RequestBody BookList bookList) {
        return new ResponseEntity<BookList>(bookService.addBookList(bookList), HttpStatus.ACCEPTED);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('plotBooking')")
    @GetMapping("/bookListDetails")
    public ResponseEntity<List<BookList>> getAllBookListDetails() {
        List<BookList> bookLists = bookService.bookListDetails();
        return ResponseEntity.ok(bookLists);
    }
    @GetMapping("/getAllBookingDetails")
    public ResponseEntity<List<Booking>> getAllBookingDetails() {
        List<Booking> bookingLists = bookService.getAllBookingDetails();
        return ResponseEntity.ok(bookingLists);
    }
    @GetMapping("/getBookingDetailsById/{bookingId}")
    public ResponseEntity<Booking> getBookingDetailsById(@PathVariable Long bookingId) {
        Booking booking = bookService.getBookingDetailsById(bookingId);
        return ResponseEntity.ok(booking);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('plotBooking')")
    @GetMapping("/getBookListById/{bookListId}")
    public ResponseEntity<BookList> getBlocksById(@PathVariable Long bookListId) {
        BookList bookList = bookService.getBookListById(bookListId);
        return ResponseEntity.ok(bookList);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('plotBooking')")
    @PutMapping("/updateBookList/{bookListId}")
    public ResponseEntity<BookList> updateBookList(@PathVariable Long bookListId, @RequestBody BookList bookList) {

        return new ResponseEntity<BookList>(bookService.updateBookList(bookListId,bookList), HttpStatus.ACCEPTED);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('plotBooking')")
    @PostMapping("/addBookRef")
    public ResponseEntity<BookRef> addBookRef(@RequestBody BookRef bookRef) {
        return new ResponseEntity<BookRef>(bookService.addBookRef(bookRef), HttpStatus.ACCEPTED);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('plotBooking')")
    @GetMapping("/bookRefDetails")
    public ResponseEntity<List<BookRef>> getAllBookRefDetails() {
        List<BookRef> bookRefs = bookService.bookRefDetails();
        return ResponseEntity.ok(bookRefs);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('plotBooking')")
    @GetMapping("/getBookRefById/{bookRefId}")
    public ResponseEntity<BookRef> getBookRefById(@PathVariable Long bookRefId) {
        BookRef bookRef = bookService.getBookRefById(bookRefId);
        return ResponseEntity.ok(bookRef);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('plotBooking')")
    @PutMapping("/updateBookRef/{bookRefId}")
    public ResponseEntity<BookRef> updateBookRef(@PathVariable Long bookRefId, @RequestBody BookRef bookRef) {

        return new ResponseEntity<BookRef>(bookService.updateBookRef(bookRefId,bookRef), HttpStatus.ACCEPTED);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('plotBooking')")
    @PostMapping("/addBookPay")
    public ResponseEntity<BookPay> addBookPay(@RequestBody BookPay bookPay) {
        return new ResponseEntity<BookPay>(bookService.addBookPay(bookPay), HttpStatus.ACCEPTED);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('plotBooking')")
    @GetMapping("/bookPayDetails")
    public ResponseEntity<List<BookPay>> getAllBookPayDetails() {
        List<BookPay> bookPays = bookService.bookPayDetails();
        return ResponseEntity.ok(bookPays);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('plotBooking')")
    @GetMapping("/getBookPayById/{bookPayId}")
    public ResponseEntity<BookPay> getBookPayById(@PathVariable Long bookPayId) {
        BookPay bookPay = bookService.getBookPayById(bookPayId);
        return ResponseEntity.ok(bookPay);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('plotBooking')")
    @PutMapping("/updateBookPay/{bookPayId}")
    public ResponseEntity<BookPay> updateBookPay(@PathVariable Long bookPayId, @RequestBody BookPay bookPay) {

        return new ResponseEntity<BookPay>(bookService.updateBookPay(bookPayId,bookPay), HttpStatus.ACCEPTED);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('plotBooking')")
    @PostMapping("/addBookChange")
    public ResponseEntity<BookChange> addBookChange(@RequestBody BookChange bookChange) {
        return new ResponseEntity<BookChange>(bookService.addBookChange(bookChange), HttpStatus.ACCEPTED);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('plotBooking')")
    @GetMapping("/BookChangeDetails")
    public ResponseEntity<List<BookChange>> getAllBookChangeDetails() {
        List<BookChange> bookChanges = bookService.BookChangeDetails();
        return ResponseEntity.ok(bookChanges);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('plotBooking')")
    @GetMapping("/getBookChangeById/{bookChangeId}")
    public ResponseEntity<BookChange> getBookChangeById(@PathVariable Long bookChangeId) {
        BookChange bookChange = bookService.getBookChangeById(bookChangeId);
        return ResponseEntity.ok(bookChange);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('plotBooking')")
    @PutMapping("/updateBookChange/{bookChangeId}")
    public ResponseEntity<BookChange> updateBookChange(@PathVariable Long bookChangeId, @RequestBody BookChange bookChange) {

        return new ResponseEntity<BookChange>(bookService.updateBookChange(bookChangeId,bookChange), HttpStatus.ACCEPTED);
    }

    @PostMapping("/addBookCancel")
    public ResponseEntity<BookCancel> addBookCancel(@RequestBody BookCancel BookCancel) {
        return new ResponseEntity<BookCancel>(bookService.addBookCancel(BookCancel), HttpStatus.ACCEPTED);
    }

    @GetMapping("/BookCancelDetails")
    public ResponseEntity<List<BookCancel>> getAllBookCancelDetails() {
        List<BookCancel> bookCancels = bookService.BookCancelDetails();
        return ResponseEntity.ok(bookCancels);
    }

    @GetMapping("/getBookCancelByCompanyId/{companyId}")
    public ResponseEntity<List<BookCancel>> getBookCancelByCompanyId(@PathVariable Long companyId) {
        List<BookCancel> bookCancels = bookService.getBookCancelByCompanyId(companyId);
        return ResponseEntity.ok(bookCancels);
    }

    @GetMapping("/bookCancelCompanyAndTeamId/{companyId}/{teamId}")
    public List<BookCancel> getBookCancelByCompanyAndTeam(@PathVariable Long companyId, @PathVariable List<Long> teamId)
    {
        return bookService.getBookCancelByCompanyIdAndTeamId(companyId, teamId);
    }

    // bookConfirm Page

    @PostMapping("/addBookConfirm")
    public ResponseEntity<BookConfirm> addBookConfirm(@RequestPart("bookConfirm") BookConfirm bookConfirm,
                                                      @RequestPart("legalDocument") MultipartFile legalDocument,
                                                      @RequestPart("agreementDocument") MultipartFile agreementDocument,
                                                      @RequestPart("idProofDocument") MultipartFile idProofDocument)
    {
        return new ResponseEntity<BookConfirm>(bookService.addBookConfirm(bookConfirm,legalDocument,agreementDocument,idProofDocument), HttpStatus.ACCEPTED);
    }
    @GetMapping("/getAllBookConfirmDetails")
    public ResponseEntity<List<BookConfirm>> getAllBookConfirmDetails() {
        List<BookConfirm> bookCancels = bookService.getAllBookConfirmDetails();
        return ResponseEntity.ok(bookCancels);
    }
    @GetMapping("/getBookConfirmById/{bookConfirmId}")
    public ResponseEntity<BookConfirm> getBookConfirmById(@PathVariable Long bookConfirmId) {
        BookConfirm bookChange = bookService.getBookConfirmById(bookConfirmId);
        return ResponseEntity.ok(bookChange);
    }
    @DeleteMapping("/deleteBookingConfirmById/{bookConfirmId}")
    public ResponseEntity<String> deleteBookingConfirmById(@PathVariable Long bookConfirmId) {
        return new ResponseEntity<String>(bookService.deleteBookingConfirmById(bookConfirmId), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getBookConfirmByCompanyId/{companyId}")
    public ResponseEntity<List<BookConfirm>> getBookConfirmByCompanyId(@PathVariable Long companyId) {
        List<BookConfirm> bookConfirms = bookService.getBookConfirmByCompanyId(companyId);
        return ResponseEntity.ok(bookConfirms);
    }

    @GetMapping("/bookConfirmCompanyAndTeamId/{companyId}/{teamId}")
    public List<BookConfirm> getBookConfirmByCompanyAndTeam(@PathVariable Long companyId, @PathVariable List<Long> teamId)
    {
        return bookService.getBookConfirmByCompanyIdAndTeamId(companyId, teamId);
    }

    @GetMapping("/getBookCustomerByCustomerId/{customerId}")
    public ResponseEntity<Booking> getBlocksByCustomerId(@PathVariable Long customerId) {
        Booking booking = bookService.getBookListByCustomerId(customerId);
        return ResponseEntity.ok(booking);
    }
    @DeleteMapping("/deleteBookById/{bookId}")
    public ResponseEntity<String> deleteBookingById(@PathVariable Long bookId) {
        return new ResponseEntity<String>(bookService.deleteBookingById(bookId), HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateBookPayment/{bookingId}/{paidAmount}/{balance}")
    public ResponseEntity<Booking> updateBookPayment(@PathVariable Long bookingId,@PathVariable Double paidAmount,@PathVariable Double balance) {

        return new ResponseEntity<Booking>(bookService.updateBookPayment(bookingId,paidAmount,balance), HttpStatus.ACCEPTED);
    }

    @PostMapping("/addNewPayment")
    public ResponseEntity<BookPay> addNewPayment(@RequestBody BookPay bookPay)
    {
        return new ResponseEntity<BookPay>(bookService.addBookPay(bookPay), HttpStatus.ACCEPTED);
    }
    @GetMapping("/getBookingDetailsByBlockId/{blockId}")
    public ResponseEntity<Booking> getBookingDetailsByBlockId(@PathVariable String blockId) {
        Booking booking = bookService.getBookingDetailsByBlockId(blockId);
        return ResponseEntity.ok(booking);
    }
    @GetMapping("/getAllBookPayDetailsByBookingId/{bookingId}")
    public ResponseEntity<List<BookPay>> getAllBookPayDetailsByBookingId(@PathVariable Long bookingId)
    {
        List<BookPay> bookPays = bookService.getAllBookPayDetailsByBookingId(bookingId);
        return ResponseEntity.ok(bookPays);
    }


    @GetMapping("/getBookingByCompanyId/{companyId}")
        public ResponseEntity<List<Booking>> getBookingByCompanyId(@PathVariable Long companyId) {
            List<Booking> booking = bookService.getBookingByCompanyId(companyId);
            return ResponseEntity.ok(booking);
    }

    @GetMapping("/getBookingByCompanyIdAndBalance/{companyId}")
    public ResponseEntity<List<Booking>> getBookingByCompanyIdAndBalance(@PathVariable Long companyId) {
        List<Booking> booking = bookService.getBookingByCompanyIdAndBalance(companyId);
        return ResponseEntity.ok(booking);
    }


    @GetMapping("/companyAndTeamId/{companyId}/{teamId}")
    public List<Booking> getBookingByCompanyAndTeam(@PathVariable Long companyId, @PathVariable List<Long> teamId)
    {
        return bookService.getBookingByCompanyIdAndTeamId(companyId, teamId);
    }

        @GetMapping("/getBookingByCompanyIdAndTeamIdAndBalance/{companyId}/{teamId}")
    public ResponseEntity<List<Booking>> getBookingByCompanyIdAndTeamIdAndBalance(
            @PathVariable Long companyId,
            @PathVariable List<Long> teamId) {
        List<Booking> bookings = bookService.getBookingByCompanyIdAndTeamIdAndBalance(companyId, teamId);
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/getBookingByCompanyIdAndNonZeroBalance/{companyId}")
    public ResponseEntity<List<Booking>> getBookingByCompanyIdAndNonZeroBalance(
            @PathVariable Long companyId) {
        List<Booking> bookings = bookService.getBookingByCompanyIdAndNonZeroBalance(companyId);
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/getBookingByCompanyIdAndTeamIdAndNonZeroBalance/{companyId}/{teamId}")
    public ResponseEntity<List<Booking>> getBookingByCompanyIdAndTeamIdAndNonZeroBalance(
            @PathVariable Long companyId,
            @PathVariable List<Long> teamId) {
        List<Booking> bookings = bookService.getBookingByCompanyIdAndTeamIdAndNonZeroBalance(companyId, teamId);
        return ResponseEntity.ok(bookings);
    }

}
