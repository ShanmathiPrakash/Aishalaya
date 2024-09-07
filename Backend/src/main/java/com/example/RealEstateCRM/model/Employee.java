package com.example.RealEstateCRM.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@Entity
@ToString
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    private Date createdOn;
    private String createdBy;
    private String employeeCode;
    private String employeeName;
    private String employeeMobile;
    private String alterMobile;
    private String employeeEmail;
    private Date dob;
    private String gender;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Role role;




    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "employee_team_ids", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "team_id")
    private List<Long> teamId;

    private Long userId; // userId field

    private String userName;
    private String password;
    private String address1;
    private String address2;
    private String area;
    private String city;
    private String district;
    private String state;
    private String pinCode;
    private String avatar;
    private String isActive;
    public void generateEmployeeCode(Long currentMaxEmployeeId) {
        String prefix = "AISE";
        String formattedNumber = String.format("%05d", currentMaxEmployeeId + 1);
        this.employeeCode = prefix + formattedNumber;
    }


    public List<Long> getTeamId() {
        return teamId;
    }

    public void setTeamId(List<Long> teamId) {
        this.teamId = teamId;
    }

    public String getIsActive() {
        return isActive;
    }


    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }


    public String getEmployeeMobile() {
        return employeeMobile;
    }

    public void setEmployeeMobile(String employeeMobile) {
        this.employeeMobile = employeeMobile;
    }

    public String getAlterMobile() {
        return alterMobile;
    }

    public void setAlterMobile(String alterMobile) {
        this.alterMobile = alterMobile;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }



    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
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

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

}

