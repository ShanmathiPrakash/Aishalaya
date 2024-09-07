package com.example.RealEstateCRM.serviceImplementationClass;

import com.example.RealEstateCRM.ExceptionHandling.ResourceNotFoundException;
import com.example.RealEstateCRM.model.*;
import com.example.RealEstateCRM.repository.*;
import com.example.RealEstateCRM.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookServiceClass implements BookService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    BookConfirmRepository bookConfirmRepository;

    @Override
    public Booking addBooking(Booking booking) {
        BookPay bookPay = new BookPay();

        bookPay.setBookingId(booking.getBookingId());
        bookPay.setCustomerId(booking.getCustomerId());
        bookPay.setCustomerName(booking.getCustomerName());
        bookPay.setMobileNumber(booking.getMobileNumber());
        bookPay.setSiteVisitEmpId(booking.getSiteVisitEmpId());
        bookPay.setBookingId(booking.getBookingId());
        bookPay.setProjectName(booking.getProjectName());
        bookPay.setPlotNumber(booking.getPlotNumber());
        bookPay.setDeno500(booking.getDeno500());
        bookPay.setDenoa500(booking.getDenoa500());
        bookPay.setDeno200(booking.getDeno200());
        bookPay.setDenoa200(booking.getDenoa200());
        bookPay.setDeno100(booking.getDeno100());
        bookPay.setDenoa100(booking.getDenoa100());
        bookPay.setDeno50(booking.getDeno50());
        bookPay.setDenoa50(booking.getDenoa50());
        bookPay.setDeno20(booking.getDeno20());
        bookPay.setDenoa20(booking.getDenoa20());
        bookPay.setDeno10(booking.getDeno10());
        bookPay.setDenoa10(booking.getDenoa10());
        bookPay.setDenoTotalNotes(booking.getDenoTotalNotes());
        bookPay.setDenoTotalAmount(booking.getDenoTotalAmount());
        bookPay.setBankName(booking.getBankName());
        bookPay.setCdtNo(booking.getCdtNo());
        bookPay.setCdtDate(booking.getCdtDate());
        bookPay.setNetAmount(booking.getNetAmount());
        bookPay.setPaidAmount(booking.getPaidAmount());
        bookPay.setPaidDate(booking.getPaidDate());
        bookPay.setPaymentType(booking.getPaymentType());
        bookPay.setPaymentMode(booking.getPaymentMode());
        bookPay.setPaidBy(booking.getPaidBy());
        bookPay.setReceivedBy(booking.getReceivedBy());
        bookPayRepository.save(bookPay);

        BookList bookList = new BookList();
        bookList.setBookingId(booking.getBookingId());
        bookList.setSiteVisitEmpId(booking.getSiteVisitEmpId());
        bookList.setCustomerId(booking.getCustomerId());
        bookList.setProjectName(booking.getProjectName());
        bookList.setPlotNumber(booking.getPlotNumber());
        bookList.setTotalSqft(booking.getTotalSqft());
        bookList.setOriginalRate(booking.getOriginalRate());
        bookList.setSellingRate(booking.getSellingRate());
        bookList.setTotalSqft(booking.getTotalSqft());
        Double diffRate = bookList.getSellingRate() - booking.getOriginalRate();
        bookList.setDifferRate(diffRate);
        bookList.setTotalAmount(booking.getPlotTotalAmount());
        bookList.setDiscount(booking.getDiscount());

        bookListRepository.save(bookList);


        // Save the booking entity
        Booking savedBooking = bookingRepository.save(booking);

        // Fetch the plotNumber from the saved booking
        Long plotNumber = savedBooking.getPlotNumber();

        // Fetch the project layout entry by plotNumber
        Optional<ProjectLayout> projectLayoutOptional = projectLayoutRepository.findByPlotNumber(plotNumber);

        if (projectLayoutOptional.isPresent()) {
            // Get the project layout from the optional
            ProjectLayout projectLayout = projectLayoutOptional.get();

            // Set the status to blocked
            projectLayout.setStatus("Booked");

            // Save the updated project layout
            projectLayoutRepository.save(projectLayout);
        } else {
            // Handle the case where the project layout is not found (optional)
            throw new EntityNotFoundException("Project layout not found for plotNumber: " + plotNumber);
        }

        return savedBooking;
    }
    @Autowired
    BookListRepository bookListRepository;

    @Override
    public BookList addBookList(BookList bookList) {
        return bookListRepository.save(bookList);
    }
    @Override
    public List<BookList> bookListDetails() {
        return bookListRepository.findAll();
    }
    @Override
    public BookList getBookListById(Long bookListId) {
        return bookListRepository.findById(bookListId)
                .orElseThrow(() -> new EntityNotFoundException("BookList not found with bookListId: " + bookListId));
    }
    @Override
    public BookList updateBookList(Long bookListId, BookList bookList) {
        Optional<BookList> ans=bookListRepository.findById(bookListId);
        BookList bookList1=ans.get();
        bookList1.setCreatedOn(bookList.getCreatedOn());
//        bookList1.setCreatedBy(bookList.getCreatedBy());
//        bookList1.setBookingId(bookList.getBookingId());
//        bookList1.setEmployeeCode(bookList.getEmployeeCode());
//        bookList1.setCustomerCode(bookList.getCustomerCode());
//        bookList1.setProjectId(bookList.getProjectId());
//        bookList1.setPlotId(bookList.getPlotId());
//        bookList1.setOriginalRate(bookList.getOriginalRate());
//        bookList1.setSqft(bookList.getSqft());
//        bookList1.setRate(bookList.getRate());
//        bookList1.setDiffRate(bookList.getDiffRate());
        bookList1.setTotalAmount(bookList.getTotalAmount());

        bookList1.setDiscount(bookList.getDiscount());

        return bookListRepository.save(bookList1);

    }
    @Autowired
    BookRefRepository bookRefRepository;
    @Override
    public BookRef addBookRef(BookRef bookRef) {
        return bookRefRepository.save(bookRef);
    }
    @Override
    public List<BookRef> bookRefDetails() {
        return bookRefRepository.findAll();
    }

    @Override
    public BookRef getBookRefById(Long bookRefId) {
        return bookRefRepository.findById(bookRefId)
                .orElseThrow(() -> new EntityNotFoundException("BookRef not found with bookRefId: " + bookRefId));
    }
    @Override
    public BookRef updateBookRef(Long bookRefId, BookRef bookRef) {
        Optional<BookRef> ans=bookRefRepository.findById(bookRefId);
        BookRef bookRef1=ans.get();
        bookRef1.setCreatedOn(bookRef.getCreatedOn());
        bookRef1.setSiteVisitEmpId(bookRef.getSiteVisitEmpId());
        bookRef1.setCustomerId(bookRef.getCustomerId());
        bookRef1.setProjectId(bookRef.getProjectId());
        bookRef1.setPlotNumber(bookRef.getPlotNumber());
        bookRef1.setBookingId(bookRef.getBookingId());
        bookRef1.setPaidAmount(bookRef.getPaidAmount());
        bookRef1.setDeductionAmount(bookRef.getDeductionAmount());
        bookRef1.setRefundAmount(bookRef.getRefundAmount());
        bookRef1.setPaidDate(bookRef.getPaidDate());
        bookRef1.setPaymentType(bookRef.getPaymentType());
        bookRef1.setPaymentMode(bookRef.getPaymentMode());
        bookRef1.setBankName(bookRef.getBankName());
        bookRef1.setCdtNo(bookRef.getCdtNo());
        bookRef1.setCdtDate(bookRef.getCdtDate());
        bookRef1.setDeno500(bookRef.getDeno500());
        bookRef1.setDenoa500(bookRef.getDenoa500());
        bookRef1.setDeno200(bookRef.getDeno200());
        bookRef1.setDenoa200(bookRef.getDenoa200());
        bookRef1.setDeno100(bookRef.getDeno100());
        bookRef1.setDenoa100(bookRef.getDenoa100());
        bookRef1.setDeno50(bookRef.getDeno50());
        bookRef1.setDenoa50(bookRef.getDenoa50());
        bookRef1.setDeno20(bookRef.getDeno20());
        bookRef1.setDenoa20(bookRef.getDenoa20());
        bookRef1.setDeno10(bookRef.getDeno10());
        bookRef1.setDenoa10(bookRef.getDenoa10());
        bookRef1.setDenoTotalNote(bookRef.getDenoTotalNote());
        bookRef1.setDenoTotalAmount(bookRef.getDenoTotalAmount());
        bookRef1.setPaidBy(bookRef.getPaidBy());
        bookRef1.setReceivedBy(bookRef.getReceivedBy());

        return bookRefRepository.save(bookRef1);
    }
    @Autowired
    BookPayRepository bookPayRepository;

    @Autowired
    ProjectLayoutRepository projectLayoutRepository;
    @Override
    public BookPay addBookPay(BookPay bookPay) {
        // Save the BookPay entity
        BookPay savedBookPay = bookPayRepository.save(bookPay);

        // Fetch the most recently saved plotNumber from the BookPay table
        Long plotNumber = savedBookPay.getPlotNumber();

        // Fetch the Booking entry by plotNumber where balance is 0
        Optional<Booking> bookingOptional = bookingRepository.findTopByPlotNumberAndBalanceOrderByBookingIdDesc(plotNumber, 0.0);

        if (bookingOptional.isPresent()) {
            // Get the Booking from the optional
            Booking booking = bookingOptional.get();

            // Fetch the ProjectLayout entry by plotNumber
            Optional<ProjectLayout> projectLayoutOptional = projectLayoutRepository.findByPlotNumber(plotNumber);

            if (projectLayoutOptional.isPresent()) {
                // Get the ProjectLayout from the optional
                ProjectLayout projectLayout = projectLayoutOptional.get();

                // Set the status to confirmed
                projectLayout.setStatus("Confirmed");

                // Save the updated ProjectLayout
                projectLayoutRepository.save(projectLayout);
            } else {
                // Handle the case where the project layout is not found (optional)
                throw new EntityNotFoundException("Project layout not found for plotNumber: " + plotNumber);
            }
        } else {
            // Handle the case where the booking is not found or balance is not zero (optional)
            throw new EntityNotFoundException("Booking not found with plotNumber and balance zero for plotNumber: " + plotNumber);
        }

        return savedBookPay;
    }




    @Override
    public List<BookPay> bookPayDetails() {
        return bookPayRepository.findAll();
    }
    @Override
    public BookPay getBookPayById(Long bookPayId) {
        return bookPayRepository.findById(bookPayId)
                .orElseThrow(() -> new EntityNotFoundException("BookPay not found with bookPayId: " + bookPayId));
    }
    @Override
    public BookPay updateBookPay(Long bookPayId, BookPay bookPay) {
        Optional<BookPay> ans=bookPayRepository.findById(bookPayId);
        BookPay bookPay1=ans.get();
//        bookPay1.setCreatedOn(bookPay.getCreatedOn());
//        bookPay1.setCreatedBy(bookPay.getCreatedBy());
//        bookPay1.setEmployeeCode(bookPay.getEmployeeCode());
//        bookPay1.setCustomerCode(bookPay.getCustomerCode());
//        bookPay1.setProjectId(bookPay.getProjectId());
//        bookPay1.setPlotId(bookPay.getPlotId());
//        bookPay1.setBookingId(bookPay.getBookingId());
//        bookPay1.setPaidAmount(bookPay.getPaidAmount());
//        bookPay1.setPaidDate(bookPay.getPaidDate());
//        bookPay1.setPaymentType(bookPay.getPaymentType());
//        bookPay1.setPaymentMode(bookPay.getPaymentMode());
//        bookPay1.setBankName(bookPay.getBankName());
//        bookPay1.setChequeNo(bookPay.getChequeNo());
//        bookPay1.setChequeDate(bookPay.getChequeDate());
//        bookPay1.setDeno500(bookPay.getDeno500());
//        bookPay1.setDenoa500(bookPay.getDenoa500());
//        bookPay1.setDeno200(bookPay.getDeno200());
//        bookPay1.setDenoa200(bookPay.getDenoa200());
//        bookPay1.setDeno100(bookPay.getDeno100());
//        bookPay1.setDenoa100(bookPay.getDenoa100());
//        bookPay1.setDeno50(bookPay.getDeno50());
//        bookPay1.setDenoa50(bookPay.getDenoa50());
//        bookPay1.setDeno20(bookPay.getDeno20());
//        bookPay1.setDenoa20(bookPay.getDenoa20());
//        bookPay1.setDeno10(bookPay.getDeno10());
//        bookPay1.setDenoa10(bookPay.getDenoa10());
//        bookPay1.setDenoTotal(bookPay.getDenoTotal());
//        bookPay1.setDenoaTotal(bookPay.getDenoaTotal());
//        bookPay1.setReceivedBy(bookPay.getReceivedBy());
//        bookPay1.setPaidBy(bookPay.getPaidBy());

        return bookPayRepository.save(bookPay1);
    }
    @Autowired
    BookChangeRepository bookChangeRepository;
    @Override
    public BookChange addBookChange(BookChange bookChange) {
        return bookChangeRepository.save(bookChange);
    }
    @Override
    public List<BookChange> BookChangeDetails() {
        return bookChangeRepository.findAll();
    }
    @Override
    public BookChange getBookChangeById(Long bookChangeId) {
        return bookChangeRepository.findById(bookChangeId)
                .orElseThrow(() -> new EntityNotFoundException("BookChange not found with bookChangeId: " + bookChangeId));
    }
    @Override
    public BookChange updateBookChange(Long bookChangeId, BookChange bookChange) {
        Optional<BookChange> ans=bookChangeRepository.findById(bookChangeId);
        BookChange bookChange1=ans.get();
        bookChange1.setCreatedOn(bookChange.getCreatedOn());
        bookChange1.setBlockId(bookChange.getBlockId());
        bookChange1.setBookingId(bookChange.getBookingId());
        bookChange1.setSiteVisitEmpId(bookChange.getSiteVisitEmpId());
        bookChange1.setCustomerId(bookChange.getCustomerId());
        bookChange1.setProjectId(bookChange.getProjectId());
        bookChange1.setPlotNumber(bookChange.getPlotNumber());
        bookChange1.setOriginalRate(bookChange.getOriginalRate());
        bookChange1.setTotalSqft(bookChange.getTotalSqft());
        bookChange1.setSellingRate(bookChange.getSellingRate());
        bookChange1.setDiffRate(bookChange.getDiffRate());
        bookChange1.setTotalAmount(bookChange.getTotalAmount());
        bookChange1.setOldPlotNumber(bookChange.getOldPlotNumber());
        bookChange1.setOldOriginalRate(bookChange.getOldOriginalRate());
        bookChange1.setTotalSqft(bookChange.getTotalSqft());
        bookChange1.setOldSellingRate(bookChange.getOldSellingRate());
        bookChange1.setOldDiffRate(bookChange.getOldDiffRate());
        bookChange1.setOldTotalAmount(bookChange.getOldTotalAmount());
        bookChange1.setStatus(bookChange.getStatus());
        bookChange1.setGmApprove(bookChange.getGmApprove());
        return bookChangeRepository.save(bookChange1);
    }

    @Autowired
    BookCancelRepository bookCancelRepository;

    @Override
    public BookCancel addBookCancel(BookCancel bookCancel) {
        return bookCancelRepository.save(bookCancel);
    }

    @Override
    public List<BookCancel> BookCancelDetails() {
        return bookCancelRepository.findAll();
    }
    @Override
    public List<Booking> getAllBookingDetails() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingDetailsById(Long bookingId) {
        return bookingRepository.findById(bookingId).get();
    }

   // Optional<VisitDetails> updateVisitDetailOptional = Optional.ofNullable(visitDetailRepository.findByVisitDetailId(VisitDetailId));
     //   return updateVisitDetailOptional.get();
//book confirm pages

    @Override
    public BookConfirm addBookConfirm(BookConfirm bookConfirm,MultipartFile legalDocument,MultipartFile agreementDocument, MultipartFile idProofDocument) {

        if (legalDocument!= null) {
            String fileName = saveLegalDocument(legalDocument);
            String logoUrl = "legalDocument/" + fileName; // Assuming uploads directory for saved logos
            bookConfirm.setLegalDocument(logoUrl);
        }
        if (agreementDocument!= null) {
            String fileName = saveAgreementDocument(agreementDocument);
            String signUrl = "agreementDocument/" + fileName; // Assuming uploads directory for saved logos
            bookConfirm.setAgreementDocument(signUrl);
        }
        if (idProofDocument!= null) {
            String fileName = saveIdProofDocument(idProofDocument);
            String sealUrl = "idProofDocument/" + fileName; // Assuming uploads directory for saved logos
            bookConfirm.setIdProofDocument(sealUrl);
        }

        // Save the BookConfirm entity
        BookConfirm savedBookConfirm = bookConfirmRepository.save(bookConfirm);

        // Fetch the plotNumber from the saved BookConfirm
        Long plotNumber = savedBookConfirm.getPlotNumber();

        // Fetch the ProjectLayout entry by plotNumber
        Optional<ProjectLayout> projectLayoutOptional = projectLayoutRepository.findByPlotNumber(plotNumber);

        if (projectLayoutOptional.isPresent()) {
            // Get the ProjectLayout from the optional
            ProjectLayout projectLayout = projectLayoutOptional.get();

            // Set the status to completed
            projectLayout.setStatus("Completed");

            // Save the updated ProjectLayout
            projectLayoutRepository.save(projectLayout);
        } else {
            // Handle the case where the project layout is not found (optional)
            throw new EntityNotFoundException("Project layout not found for plotNumber: " + plotNumber);
        }

        return savedBookConfirm;
    }

    private String saveIdProofDocument(MultipartFile idProofDocument) {
        try {
            // Generate unique filename
            String fileName2 = UUID.randomUUID().toString() + "_" + idProofDocument.getOriginalFilename();
            // Define directory to save files
            String uploadDirStr = "alldocuments/idProofDocument/"; // Relative path to the directory
            Path uploadDir = Paths.get(uploadDirStr);
            // Resolve the absolute path
            Path absoluteUploadDir = Paths.get(System.getProperty("user.dir")).resolve(uploadDir);
            // Create directory if it doesn't exist
            if (!Files.exists(absoluteUploadDir)) {
                Files.createDirectories(absoluteUploadDir);
            }
            // Save file to directory
            Path filePath = absoluteUploadDir.resolve(fileName2);
            Files.copy(idProofDocument.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return fileName2; // Return the saved filename
        } catch (IOException e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
            return null; // Or throw an exception here
        }
    }

    private String saveAgreementDocument(MultipartFile agreementDocument) {
        try {
            // Generate unique filename
            String fileName1 = UUID.randomUUID().toString() + "_" + agreementDocument.getOriginalFilename();
            // Define directory to save files
            String uploadDirStr = "alldocuments/agreementDocument/"; // Relative path to the directory
            Path uploadDir = Paths.get(uploadDirStr);
            // Resolve the absolute path
            Path absoluteUploadDir = Paths.get(System.getProperty("user.dir")).resolve(uploadDir);
            // Create directory if it doesn't exist
            if (!Files.exists(absoluteUploadDir)) {
                Files.createDirectories(absoluteUploadDir);
            }
            // Save file to directory
            Path filePath = absoluteUploadDir.resolve(fileName1);
            Files.copy(agreementDocument.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return fileName1; // Return the saved filename
        } catch (IOException e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
            return null; // Or throw an exception here
        }
    }

    private String saveLegalDocument(MultipartFile legalDocument) {
        try {
            // Generate unique filename
            String fileName = UUID.randomUUID().toString() + "_" + legalDocument.getOriginalFilename();
            // Define directory to save files
            String uploadDirStr = "alldocuments/legalDocument/"; // Relative path to the directory
            Path uploadDir = Paths.get(uploadDirStr);
            // Resolve the absolute path
            Path absoluteUploadDir = Paths.get(System.getProperty("user.dir")).resolve(uploadDir);
            // Create directory if it doesn't exist
            if (!Files.exists(absoluteUploadDir)) {
                Files.createDirectories(absoluteUploadDir);
            }
            // Save file to directory
            Path filePath = absoluteUploadDir.resolve(fileName);
            Files.copy(legalDocument.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return fileName; // Return the saved filename
        } catch (IOException e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
            return null; // Or throw an exception here
        }
    }
    @Override
    public List<BookConfirm>  getAllBookConfirmDetails() {
        return bookConfirmRepository.findAll();
    }
    @Override
    public BookConfirm getBookConfirmById(Long bookConfirmId) {
        return bookConfirmRepository.findById(bookConfirmId).get();
    }
    @Override
    public String deleteBookingConfirmById(Long bookConfirmId) {
        Optional<BookConfirm> myData = bookConfirmRepository.findById(bookConfirmId);
        if (myData.isPresent()) {
            bookConfirmRepository.deleteById(bookConfirmId);
            return "Booking Deleted...Successfully...";
        }
        return "Booking Deletion...Failed...";
    }

    public  Booking getBookListByCustomerId(Long customerId){
        return bookingRepository.findByCustomerId(customerId).orElseThrow(()-> new EntityNotFoundException("Booking not found"+customerId));
    }

    @Override
    public String deleteBookingById(Long bookingId) {
        Optional<Booking> myData = bookingRepository.findById(bookingId);
        if (myData.isPresent()) {
            bookingRepository.deleteById(bookingId);
            return "Booking Deleted...Successfully...";
        }
        return "Booking Deletion...Failed...";
    }

    @Override
    public Booking updateBookPayment(Long bookingId, Double paidAmount, Double balance)
    {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        if (optionalBooking.isPresent())
        {
            Booking booking = optionalBooking.get();
            booking.setTotalPaidAmount(booking.getTotalPaidAmount()+paidAmount);
            booking.setBalance(booking.getBalance()-paidAmount);
            return bookingRepository.save(booking);
        }
        else
        {
            throw new ResourceNotFoundException("Booking not found with id: " + bookingId);
        }
    }
    @Override
    public BookPay addNewPayment(BookPay newBookPay) {
        BookPay bookPay = new BookPay();
        bookPay.setCustomerId(newBookPay.getCustomerId());
        bookPay.setCustomerName(newBookPay.getCustomerName());
        bookPay.setMobileNumber(newBookPay.getMobileNumber());
        bookPay.setSiteVisitEmpId(newBookPay.getSiteVisitEmpId());
        bookPay.setBookingId(newBookPay.getBookingId());
        bookPay.setProjectName(newBookPay.getProjectName());
        bookPay.setPlotNumber(newBookPay.getPlotNumber());
        bookPay.setDeno500(newBookPay.getDeno500());
        bookPay.setDenoa500(newBookPay.getDenoa500());
        bookPay.setDeno200(newBookPay.getDeno200());
        bookPay.setDenoa200(newBookPay.getDenoa200());
        bookPay.setDeno100(newBookPay.getDeno100());
        bookPay.setDenoa100(newBookPay.getDenoa100());
        bookPay.setDeno50(newBookPay.getDeno50());
        bookPay.setDenoa50(newBookPay.getDenoa50());
        bookPay.setDeno20(newBookPay.getDeno20());
        bookPay.setDenoa20(newBookPay.getDenoa20());
        bookPay.setDeno10(newBookPay.getDeno10());
        bookPay.setDenoa10(newBookPay.getDenoa10());
        bookPay.setDenoTotalNotes(newBookPay.getDenoTotalNotes());
        bookPay.setDenoTotalAmount(newBookPay.getDenoTotalAmount());
        bookPay.setBankName(newBookPay.getBankName());
        bookPay.setCdtNo(newBookPay.getCdtNo());
        bookPay.setCdtDate(newBookPay.getCdtDate());
        bookPay.setNetAmount(newBookPay.getNetAmount());
        bookPay.setPaidAmount(newBookPay.getPaidAmount());
        bookPay.setPaidDate(newBookPay.getPaidDate());
        bookPay.setPaymentType(newBookPay.getPaymentType());
        bookPay.setPaymentMode(newBookPay.getPaymentMode());
        bookPay.setPaidBy(newBookPay.getPaidBy());
        bookPay.setReceivedBy(newBookPay.getReceivedBy());
        return bookPayRepository.save(bookPay);
    }

    @Override
    public Booking getBookingDetailsByBlockId(String blockId)
    {
        return bookingRepository.findByBlockId(blockId)
                .orElseThrow(() -> new EntityNotFoundException("BookPay not found with bookPayId: " + blockId));
    }

    @Override
    public List<BookPay>  getAllBookPayDetailsByBookingId(Long bookingId)
    {
        return bookPayRepository.findByBookingId(bookingId);
    }

    @Override
    public List<Booking> getBookingByCompanyId(Long companyId) {
        List<Booking> bookings = bookingRepository.findByCompanyId(companyId);
        if (bookings.isEmpty()) {
            throw new EntityNotFoundException("booking not found for companyId: " + companyId);
        }
        return bookings;
    }

    @Override
    public List<Booking> getBookingByCompanyIdAndTeamId(Long companyId, List<Long> teamId) {
        return bookingRepository.findByCompanyIdAndTeamIdIn(companyId, teamId);
    }

    @Override
    public List<Booking> getBookingByCompanyIdAndBalance(Long companyId) {
        List<Booking> bookings = bookingRepository.findByCompanyIdAndBalance(companyId, 0.0);
        if (bookings.isEmpty()) {
            throw new EntityNotFoundException("No bookings with a balance of 0 found for companyId: " + companyId);
        }
        return bookings;
    }

    @Override
    public List<Booking> getBookingByCompanyIdAndTeamIdAndBalance(Long companyId, List<Long> teamId) {
        List<Booking> bookings = bookingRepository.findByCompanyIdAndTeamIdInAndBalance(companyId, teamId, 0.0);
        if (bookings.isEmpty()) {
            throw new EntityNotFoundException("No bookings with a balance of 0 found for companyId: " + companyId + " and teamIds: " + teamId);
        }
        return bookings;
    }

    @Override
    public List<BookConfirm> getBookConfirmByCompanyId(Long companyId) {
        List<BookConfirm> bookConfirms = bookConfirmRepository.findByCompanyId(companyId);
        if (bookConfirms.isEmpty()) {
            throw new EntityNotFoundException("BookConfirm not found for companyId: " + companyId);
        }
        return bookConfirms;
    }

    @Override
    public List<BookConfirm> getBookConfirmByCompanyIdAndTeamId(Long companyId, List<Long> teamId) {
        return bookConfirmRepository.findByCompanyIdAndTeamIdIn(companyId, teamId);
    }

    @Override
    public List<BookCancel> getBookCancelByCompanyId(Long companyId) {
        List<BookCancel> bookCancels = bookCancelRepository.findByCompanyId(companyId);
        if (bookCancels.isEmpty()) {
            throw new EntityNotFoundException("BookCancel not found for companyId: " + companyId);
        }
        return bookCancels;
    }

    @Override
    public List<BookCancel> getBookCancelByCompanyIdAndTeamId(Long companyId, List<Long> teamId) {
        return bookCancelRepository.findByCompanyIdAndTeamIdIn(companyId, teamId);
    }


    @Override
    public List<Booking> getBookingByCompanyIdAndNonZeroBalance(Long companyId) {
        // Fetch bookings where balance is not 0
        List<Booking> bookings = bookingRepository.findByCompanyIdAndBalanceNot(companyId, 0.0);
        if (bookings.isEmpty()) {
            throw new EntityNotFoundException("No bookings found with non-zero balance for companyId: " + companyId);
        }
        return bookings;
    }

    @Override
    public List<Booking> getBookingByCompanyIdAndTeamIdAndNonZeroBalance(Long companyId, List<Long> teamId) {
        // Fetch bookings where balance is not 0
        List<Booking> bookings = bookingRepository.findByCompanyIdAndTeamIdInAndBalanceNot(companyId, teamId, 0.0);
        if (bookings.isEmpty()) {
            throw new EntityNotFoundException("No bookings found with non-zero balance for companyId: " + companyId + " and teamIds: " + teamId);
        }
        return bookings;
    }

}
