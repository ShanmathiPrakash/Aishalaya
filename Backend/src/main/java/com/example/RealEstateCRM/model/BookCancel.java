package com.example.RealEstateCRM.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "BookCancel")
public class BookCancel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookCancelId;
    private String customerId;
    private String customerName;
    private String bookCancelEmpId;
    private String bookCancelEmpName;
    private String bookingEmpId;
    private String bookingEmpNAme;
    private String customerCode;
    private String mobileNumber;
    private String project;
    private Long plotNumber;
    private Double totalSqft;
    private Double ratePerSqft;
    private Double totalValues;
    private String description;
    private String rateProject;
    private String purchasedPlotNo;
    private Double purchasedTotalSqft;
    private Double purchasedRatePerSqft;
    private Double purchasedTotalValues;
    private String purchasedDiscount;
    private Long deno500;
    private Long denoa500;
    private Long deno200;
    private Long denoa200;
    private Long deno100;
    private Long denoa100;
    private Long deno50;
    private Long denoa50;
    private Long deno20;
    private Long denoa20;
    private Long deno10;
    private Long denoa10;
    private Double denoTotalNotes;
    private Double denoTotalAmount;
    private String bankName;
    private String cdtNo;
    private Date cdtDate;
    private Double refundAmount;
    private Double paidAmount;
    private Double deductionAmount;
    private Date refundDate;
    private String paymentType;
    private String paymentMode;
    private String paidBy;
    private String receivedBy;
    private Long companyId;
    private Long teamId;
}
