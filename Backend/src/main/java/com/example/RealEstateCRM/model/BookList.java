package com.example.RealEstateCRM.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "BookList")
public class BookList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookListId;
    private Date createdOn;
    private Long bookingId;
    private String siteVisitEmpId;
    private Long customerId;
    private String projectName;
    private Long plotNumber;
    private Double totalSqft;
    private Double originalRate;

    private Double sellingRate;

    private Double differRate;

    private Double totalAmount;

    private Double discount;


    public Long getBookListId() {
        return bookListId;
    }

    public void setBookListId(Long bookListId) {
        this.bookListId = bookListId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }


    public String getSiteVisitEmpId() {
        return siteVisitEmpId;
    }

    public void setSiteVisitEmpId(String siteVisitEmpId) {
        this.siteVisitEmpId = siteVisitEmpId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getPlotNumber() {
        return plotNumber;
    }

    public void setPlotNumber(Long plotNumber) {
        this.plotNumber = plotNumber;
    }

    public Double getTotalSqft() {
        return totalSqft;
    }

    public void setTotalSqft(Double totalSqft) {
        this.totalSqft = totalSqft;
    }

    public Double getOriginalRate() {
        return originalRate;
    }

    public void setOriginalRate(Double originalRate) {
        this.originalRate = originalRate;
    }

    public Double getSellingRate() {
        return sellingRate;
    }

    public void setSellingRate(Double sellingRate) {
        this.sellingRate = sellingRate;
    }

    public Double getDifferRate() {
        return differRate;
    }

    public void setDifferRate(Double differRate) {
        this.differRate = differRate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }



    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
