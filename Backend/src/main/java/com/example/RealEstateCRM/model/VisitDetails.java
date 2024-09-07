package com.example.RealEstateCRM.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "VisitDetails")
public class VisitDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long visitDetailId;
        private String employeeCode;
        private Long companyId;
        private Long teamId;
        @ElementCollection
        private List<String> projectNames;
        private Date date;
        private String customerName;
        private String phoneNumber;
        private String employeeName;
        private String status;
        private String fundingSource;
        private String buyingDuration;
        private String vehicleType;
        private String cab;
        private String driver;
        private Double startingKms;
        private Double endKms;
        private Date startingTime;
        private String employeeNotes;
        private String photo;
        private Boolean isBlock;
        private Boolean isBook;
        private String endingTime;

        public Long getVisitDetailId() {
                return visitDetailId;
        }
        public void setVisitDetailId(Long visitDetailId) {
                this.visitDetailId = visitDetailId;
        }
        public String getEmployeeCode() {
                return employeeCode;
        }
        public void setEmployeeCode(String employeeCode) {
                this.employeeCode = employeeCode;
        }
        public Long getCompanyId() {
                return companyId;
        }

        public void setCompanyId(Long companyId) {
                this.companyId = companyId;
        }
        public List<String> getProjectNames() {
                return projectNames;
        }
        public void setProjectNames(List<String> projectNames) {
                this.projectNames = projectNames;
        }
        public Date getDate() {
                return date;
        }
        public void setDate(Date date) {
                this.date = date;
        }
        public String getCustomerName() {
                return customerName;
        }
        public void setCustomerName(String customerName) {
                this.customerName = customerName;
        }
        public String getPhoneNumber() {
                return phoneNumber;
        }
        public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
        }
        public String getEmployeeName() {
                return employeeName;
        }
        public void setEmployeeName(String employeeName) {
                this.employeeName = employeeName;
        }
        public String getStatus() {
                return status;
        }
        public void setStatus(String status) {
                this.status = status;
        }
        public String getFundingSource() {
                return fundingSource;
        }

        public void setFundingSource(String fundingSource) {
                this.fundingSource = fundingSource;
        }

        public String getBuyingDuration() {
                return buyingDuration;
        }

        public void setBuyingDuration(String buyingDuration) {
                this.buyingDuration = buyingDuration;
        }

        public String getVehicleType() {
                return vehicleType;
        }

        public void setVehicleType(String vehicleType) {
                this.vehicleType = vehicleType;
        }

        public String getCab() {
                return cab;
        }

        public void setCab(String cab) {
                this.cab = cab;
        }

        public String getDriver() {
                return driver;
        }

        public void setDriver(String driver) {
                this.driver = driver;
        }

        public Double getStartingKms() {
                return startingKms;
        }

        public void setStartingKms(Double startingKms) {
                this.startingKms = startingKms;
        }

        public Double getEndKms() {
                return endKms;
        }

        public void setEndKms(Double endKms) {
                this.endKms = endKms;
        }

        public Date getStartingTime() {
                return startingTime;
        }

        public void setStartingTime(Date startingTime) {
                this.startingTime = startingTime;
        }

        public String getEmployeeNotes() {
                return employeeNotes;
        }

        public void setEmployeeNotes(String employeeNotes) {
                this.employeeNotes = employeeNotes;
        }

        public String getPhoto() {
                return photo;
        }

        public void setPhoto(String photo) {
                this.photo = photo;
        }
}
