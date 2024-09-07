package com.example.RealEstateCRM.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "BookRef")
public class BookRef {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookRefId;
    private Date createdOn;
    private String siteVisitEmpId;
    private String customerId;
    private Long projectId;
    private Long plotNumber;
    private Long bookingId;

    private Double paidAmount;
    private Double deductionAmount;
    private Double refundAmount;
    private Date paidDate;
    private String paymentType;
    private String paymentMode;
    private String bankName;
    private String cdtNo;
    private Date cdtDate;
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
    private Long denoTotalNote;
    private Long denoTotalAmount;

    private String paidBy;

    private String receivedBy;

    public Long getBookRefId() {
        return bookRefId;
    }

    public void setBookRefId(Long bookRefId) {
        this.bookRefId = bookRefId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getSiteVisitEmpId() {
        return siteVisitEmpId;
    }

    public void setSiteVisitEmpId(String siteVisitEmpId) {
        this.siteVisitEmpId = siteVisitEmpId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getPlotNumber() {
        return plotNumber;
    }

    public void setPlotNumber(Long plotNumber) {
        this.plotNumber = plotNumber;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Double getDeductionAmount() {
        return deductionAmount;
    }

    public void setDeductionAmount(Double deductionAmount) {
        this.deductionAmount = deductionAmount;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCdtNo() {
        return cdtNo;
    }

    public void setCdtNo(String cdtNo) {
        this.cdtNo = cdtNo;
    }

    public Date getCdtDate() {
        return cdtDate;
    }

    public void setCdtDate(Date cdtDate) {
        this.cdtDate = cdtDate;
    }

    public Long getDeno500() {
        return deno500;
    }

    public void setDeno500(Long deno500) {
        this.deno500 = deno500;
    }

    public Long getDenoa500() {
        return denoa500;
    }

    public void setDenoa500(Long denoa500) {
        this.denoa500 = denoa500;
    }

    public Long getDeno200() {
        return deno200;
    }

    public void setDeno200(Long deno200) {
        this.deno200 = deno200;
    }

    public Long getDenoa200() {
        return denoa200;
    }

    public void setDenoa200(Long denoa200) {
        this.denoa200 = denoa200;
    }

    public Long getDeno100() {
        return deno100;
    }

    public void setDeno100(Long deno100) {
        this.deno100 = deno100;
    }

    public Long getDenoa100() {
        return denoa100;
    }

    public void setDenoa100(Long denoa100) {
        this.denoa100 = denoa100;
    }

    public Long getDeno50() {
        return deno50;
    }

    public void setDeno50(Long deno50) {
        this.deno50 = deno50;
    }

    public Long getDenoa50() {
        return denoa50;
    }

    public void setDenoa50(Long denoa50) {
        this.denoa50 = denoa50;
    }

    public Long getDeno20() {
        return deno20;
    }

    public void setDeno20(Long deno20) {
        this.deno20 = deno20;
    }

    public Long getDenoa20() {
        return denoa20;
    }

    public void setDenoa20(Long denoa20) {
        this.denoa20 = denoa20;
    }

    public Long getDeno10() {
        return deno10;
    }

    public void setDeno10(Long deno10) {
        this.deno10 = deno10;
    }

    public Long getDenoa10() {
        return denoa10;
    }

    public void setDenoa10(Long denoa10) {
        this.denoa10 = denoa10;
    }

    public Long getDenoTotalNote() {
        return denoTotalNote;
    }

    public void setDenoTotalNote(Long denoTotalNote) {
        this.denoTotalNote = denoTotalNote;
    }

    public Long getDenoTotalAmount() {
        return denoTotalAmount;
    }

    public void setDenoTotalAmount(Long denoTotalAmount) {
        this.denoTotalAmount = denoTotalAmount;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    public String getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(String receivedBy) {
        this.receivedBy = receivedBy;
    }
}
