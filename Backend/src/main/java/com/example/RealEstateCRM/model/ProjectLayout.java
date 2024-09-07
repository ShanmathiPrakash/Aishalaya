package com.example.RealEstateCRM.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ProjectLayout")
public class ProjectLayout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ProjectLayoutId;
    private Long plotNumber;
    private Long projectId;
    private String shape;
    private String descrip;
    private Double totalSqft;
    private Double rate;
    private Double totalValue;
    private Double msp;
    private String status;
    private String projectName;
    private Long teamId;

    public Long getProjectLayoutId() {
        return ProjectLayoutId;
    }

    public void setProjectLayoutId(Long projectLayoutId) {
        ProjectLayoutId = projectLayoutId;
    }

    public Long getPlotNumber() {
        return plotNumber;
    }

    public void setPlotNumber(Long plotNumber) {
        this.plotNumber = plotNumber;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Double getTotalSqft() {
        return totalSqft;
    }

    public void setTotalSqft(Double totalSqft) {
        this.totalSqft = totalSqft;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Double getMsp() {
        return msp;
    }

    public void setMsp(Double msp) {
        this.msp = msp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
