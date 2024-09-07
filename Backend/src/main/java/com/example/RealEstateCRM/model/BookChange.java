package com.example.RealEstateCRM.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "BookChange")
public class BookChange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookChangeId;
    private Date createdOn;
    private Long bookingId;
    private Long blockId;
    private String siteVisitEmpId;
    private String customerId;
    private Long projectId;
    private Long plotNumber;
    private Double originalRate;
    private Double totalSqft;
    private Double sellingRate;
    private Double diffRate;
    private Double totalAmount;
    private Long oldPlotNumber;
    private Double oldOriginalRate;
    private Double oldTotalSqft;
    private Double oldSellingRate;
    private Double oldDiffRate;
    private Double oldTotalAmount;
    private String status;
    private Boolean gmApprove;
    private Long companyId;
    private Long teamId;


    public Long getBookChangeId() {
        return bookChangeId;
    }
    public void setBookChangeId(Long bookChangeId) {
        this.bookChangeId = bookChangeId;
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

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
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

    public Double getOriginalRate() {
        return originalRate;
    }

    public void setOriginalRate(Double originalRate) {
        this.originalRate = originalRate;
    }

    public Double getTotalSqft() {
        return totalSqft;
    }

    public void setTotalSqft(Double totalSqft) {
        this.totalSqft = totalSqft;
    }

    public Double getSellingRate() {
        return sellingRate;
    }

    public void setSellingRate(Double sellingRate) {
        this.sellingRate = sellingRate;
    }

    public Double getDiffRate() {
        return diffRate;
    }

    public void setDiffRate(Double diffRate) {
        this.diffRate = diffRate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getOldPlotNumber() {
        return oldPlotNumber;
    }

    public void setOldPlotNumber(Long oldPlotNumber) {
        this.oldPlotNumber = oldPlotNumber;
    }

    public Double getOldOriginalRate() {
        return oldOriginalRate;
    }

    public void setOldOriginalRate(Double oldOriginalRate) {
        this.oldOriginalRate = oldOriginalRate;
    }

    public Double getOldTotalSqft() {
        return oldTotalSqft;
    }

    public void setOldTotalSqft(Double oldTotalSqft) {
        this.oldTotalSqft = oldTotalSqft;
    }

    public Double getOldSellingRate() {
        return oldSellingRate;
    }

    public void setOldSellingRate(Double oldSellingRate) {
        this.oldSellingRate = oldSellingRate;
    }

    public Double getOldDiffRate() {
        return oldDiffRate;
    }

    public void setOldDiffRate(Double oldDiffRate) {
        this.oldDiffRate = oldDiffRate;
    }

    public Double getOldTotalAmount() {
        return oldTotalAmount;
    }

    public void setOldTotalAmount(Double oldTotalAmount) {
        this.oldTotalAmount = oldTotalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getGmApprove() {
        return gmApprove;
    }

    public void setGmApprove(Boolean gmApprove) {
        this.gmApprove = gmApprove;
    }
}
