package com.example.RealEstateCRM.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "Blocks")
public class Blocks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long blocksId;
    private Long customerId;
    private Long companyId;
    private Long teamId;
    private Long visitId;
    private String customerName;
    private String mobileNumber;
    private String customerCode;
    private String siteVisitEmpId;
    private String siteVisitEmpName;
    private String blockEmpId;
    private String blockEmpName;
    private String preferLocation;
    private String employeeType;
    private String employeeCode;
    private String workPlace;
    private String address;
    private String email;
    private String houseName;
    private String streetName;
    private String area;
    private String city;
    private String district;
    private String state;
    private String postalCode;
    private String projectName;
    private Long plotId;
    private Long plotNumber;
    private Long projectId;
    private Double totalSqft;
    private Double ratePerSqft;
    private Double totalValues;
    private String status;
    private String description;
    private Double sellingRate;
    private Double plotTotalAmount;
    private Double discount;
    private Double netAmount;
    private Double paidAmount;
    private Date paidDate;
    private String paymentType;
    private String paymentMode;
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
    private Long denoTotalNotes;
    private Double denoTotalAmount;
    private String bankName;
    private String cdtNo;
    private Date cdtDate;
    private String paidBy;
    private String receivedBy;

    public Long getBlocksId() {
        return blocksId;
    }

    public void setBlocksId(Long blocksId) {
        this.blocksId = blocksId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getSiteVisitEmpId() {
        return siteVisitEmpId;
    }

    public void setSiteVisitEmpId(String siteVisitEmpId) {
        this.siteVisitEmpId = siteVisitEmpId;
    }

    public String getSiteVisitEmpName() {
        return siteVisitEmpName;
    }

    public void setSiteVisitEmpName(String siteVisitEmpName) {
        this.siteVisitEmpName = siteVisitEmpName;
    }

    public String getBlockEmpId() {
        return blockEmpId;
    }

    public void setBlockEmpId(String blockEmpId) {
        this.blockEmpId = blockEmpId;
    }

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public String getBlockEmpName() {
        return blockEmpName;
    }

    public void setBlockEmpName(String blockEmpName) {
        this.blockEmpName = blockEmpName;
    }

    public String getPreferLocation() {
        return preferLocation;
    }

    public void setPreferLocation(String preferLocation) {
        this.preferLocation = preferLocation;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getPlotId() {
        return plotId;
    }

    public void setPlotId(Long plotId) {
        this.plotId = plotId;
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

    public Double getRatePerSqft() {
        return ratePerSqft;
    }

    public void setRatePerSqft(Double ratePerSqft) {
        this.ratePerSqft = ratePerSqft;
    }

    public Double getTotalValues() {
        return totalValues;
    }

    public void setTotalValues(Double totalValues) {
        this.totalValues = totalValues;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSellingRate() {
        return sellingRate;
    }

    public void setSellingRate(Double sellingRate) {
        this.sellingRate = sellingRate;
    }

    public Double getPlotTotalAmount() {
        return plotTotalAmount;
    }

    public void setPlotTotalAmount(Double plotTotalAmount) {
        this.plotTotalAmount = plotTotalAmount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(Double netAmount) {
        this.netAmount = netAmount;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
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

    public Long getDenoTotalNotes() {
        return denoTotalNotes;
    }

    public void setDenoTotalNotes(Long denoTotalNotes) {
        this.denoTotalNotes = denoTotalNotes;
    }

    public Double getDenoTotalAmount() {
        return denoTotalAmount;
    }

    public void setDenoTotalAmount(Double denoTotalAmount) {
        this.denoTotalAmount = denoTotalAmount;
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
