package com.example.RealEstateCRM.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "Project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String companyName;
    private String projectName;
    private LocalDate launchDate;
    private String landType;
    private String district;
    private String taluk;
    private String village;
    private Double extent;
    private String address;
    private String geoLocation;
    private Double totalSiteSqft;
    private Double totalSiteCent;
    private Double saleableSqft;
    private Double saleableCent;
    private Double roadSqft;
    private Double roadCent;
    private Long totalPlots;
    private String eastDetails;
    private String westDetails;
    private String northDetails;
    private String southDetails;
    private String prevOwnerName;
    private String prevOwnerContact;
    private String prevOwnerAddress;
    private String agreementDetails;
    private String agreementDocuments;
    private String draftDetails;
    private String draftDocuments;
    private String legalDetails;
    private String legalDocuments;
    private String documentDetails;
    private String documentDocuments;
    private String legalBookDetails;
    private String legalBookDocuments;
    private String dtcpDetails;
    private String dtcpDocuments;
    private String corporationDetails;
    private String corporationDocuments;
    private String registrationDetails;
    private String layout;
    private Long companyId;
    private Long teamId;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    public String getLandType() {
        return landType;
    }

    public void setLandType(String landType) {
        this.landType = landType;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTaluk() {
        return taluk;
    }

    public void setTaluk(String taluk) {
        this.taluk = taluk;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }



    public Double getExtent() {
        return extent;
    }

    public void setExtent(Double extent) {
        this.extent = extent;
    }


 public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }

    public Double getTotalSiteSqft() {
        return totalSiteSqft;
    }

    public void setTotalSiteSqft(Double totalSiteSqft) {
        this.totalSiteSqft = totalSiteSqft;
    }

    public Double getTotalSiteCent() {
        return totalSiteCent;
    }

    public void setTotalSiteCent(Double totalSiteCent) {
        this.totalSiteCent = totalSiteCent;
    }

    public Double getSaleableSqft() {
        return saleableSqft;
    }

    public void setSaleableSqft(Double saleableSqft) {
        this.saleableSqft = saleableSqft;
    }

    public Double getSaleableCent() {
        return saleableCent;
    }

    public void setSaleableCent(Double saleableCent) {
        this.saleableCent = saleableCent;
    }

    public Double getRoadSqft() {
        return roadSqft;
    }

    public void setRoadSqft(Double roadSqft) {
        this.roadSqft = roadSqft;
    }

    public Double getRoadCent() {
        return roadCent;
    }

    public void setRoadCent(Double roadCent) {
        this.roadCent = roadCent;
    }

    public Long getTotalPlots() {
        return totalPlots;
    }

    public void setTotalPlots(Long totalPlots) {
        this.totalPlots = totalPlots;
    }

    public String getEastDetails() {
        return eastDetails;
    }

    public void setEastDetails(String eastDetails) {
        this.eastDetails = eastDetails;
    }

    public String getWestDetails() {
        return westDetails;
    }

    public void setWestDetails(String westDetails) {
        this.westDetails = westDetails;
    }

    public String getNorthDetails() {
        return northDetails;
    }

    public void setNorthDetails(String northDetails) {
        this.northDetails = northDetails;
    }

    public String getSouthDetails() {
        return southDetails;
    }

    public void setSouthDetails(String southDetails) {
        this.southDetails = southDetails;
    }

    public String getPrevOwnerName() {
        return prevOwnerName;
    }

    public void setPrevOwnerName(String prevOwnerName) {
        this.prevOwnerName = prevOwnerName;
    }

    public String getPrevOwnerContact() {
        return prevOwnerContact;
    }

    public void setPrevOwnerContact(String prevOwnerContact) {
        this.prevOwnerContact = prevOwnerContact;
    }

    public String getPrevOwnerAddress() {
        return prevOwnerAddress;
    }

    public void setPrevOwnerAddress(String prevOwnerAddress) {
        this.prevOwnerAddress = prevOwnerAddress;
    }

    public String getAgreementDetails() {
        return agreementDetails;
    }

    public void setAgreementDetails(String agreementDetails) {
        this.agreementDetails = agreementDetails;
    }

    public String getAgreementDocuments() {
        return agreementDocuments;
    }

    public void setAgreementDocuments(String agreementDocuments) {
        this.agreementDocuments = agreementDocuments;
    }

    public String getDraftDetails() {
        return draftDetails;
    }

    public void setDraftDetails(String draftDetails) {
        this.draftDetails = draftDetails;
    }

    public String getDraftDocuments() {
        return draftDocuments;
    }

    public void setDraftDocuments(String draftDocuments) {
        this.draftDocuments = draftDocuments;
    }

    public String getLegalDetails() {
        return legalDetails;
    }

    public void setLegalDetails(String legalDetails) {
        this.legalDetails = legalDetails;
    }

    public String getLegalDocuments() {
        return legalDocuments;
    }

    public void setLegalDocuments(String legalDocuments) {
        this.legalDocuments = legalDocuments;
    }

    public String getDocumentDetails() {
        return documentDetails;
    }

    public void setDocumentDetails(String documentDetails) {
        this.documentDetails = documentDetails;
    }

    public String getDocumentDocuments() {
        return documentDocuments;
    }

    public void setDocumentDocuments(String documentDocuments) {
        this.documentDocuments = documentDocuments;
    }

    public String getLegalBookDetails() {
        return legalBookDetails;
    }

    public void setLegalBookDetails(String legalBookDetails) {
        this.legalBookDetails = legalBookDetails;
    }

    public String getLegalBookDocuments() {
        return legalBookDocuments;
    }

    public void setLegalBookDocuments(String legalBookDocuments) {
        this.legalBookDocuments = legalBookDocuments;
    }

    public String getDtcpDetails() {
        return dtcpDetails;
    }

    public void setDtcpDetails(String dtcpDetails) {
        this.dtcpDetails = dtcpDetails;
    }

    public String getDtcpDocuments() {
        return dtcpDocuments;
    }

    public void setDtcpDocuments(String dtcpDocuments) {
        this.dtcpDocuments = dtcpDocuments;
    }

    public String getCorporationDetails() {
        return corporationDetails;
    }

    public void setCorporationDetails(String corporationDetails) {
        this.corporationDetails = corporationDetails;
    }

    public String getCorporationDocuments() {
        return corporationDocuments;
    }

    public void setCorporationDocuments(String corporationDocuments) {
        this.corporationDocuments = corporationDocuments;
    }

    public String getRegistrationDetails() {
        return registrationDetails;
    }

    public void setRegistrationDetails(String registrationDetails) {
        this.registrationDetails = registrationDetails;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }
}
