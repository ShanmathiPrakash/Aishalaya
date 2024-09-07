package com.example.RealEstateCRM.model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
@Data
@Entity
@Table
public class BookConfirm
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookConfirmId;
    private Long bookingId;
    private String customerCode;
    private Long mobileNumber;
    private String email;
    private String project;
    private Long plotNumber;
    private Date date;
    private Double totalSqft;
    private Double ratePerSqft;
    private Double totalValues;
    private String description;
    private String plotConfirmedEmployeeEmail;
    private String legalDocument;
    private String agreementDocument;
    private String idProofDocument;
    private String legalDocumentSerialNumber;
    private String agreementDocumentSerialNumber;
    private String idProofDocumentSerialNumber;
    private Long companyId;
    private Long teamId;
}
