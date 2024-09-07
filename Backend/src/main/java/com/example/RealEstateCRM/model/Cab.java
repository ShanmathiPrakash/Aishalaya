package com.example.RealEstateCRM.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Cab")
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cabId;
    private String cabName;
    private String employeeName;
    private String department;
    private String vehicleType;

    public Long getCabId() {
        return cabId;
    }

    public void setCabId(Long cabId) {
        this.cabId = cabId;
    }

    public String getCabName() {
        return cabName;
    }

    public void setCabName(String cabName) {
        this.cabName = cabName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
