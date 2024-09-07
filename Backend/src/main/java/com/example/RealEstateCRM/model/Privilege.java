package com.example.RealEstateCRM.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "privilege")
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long privilegeId;

    @ManyToOne
    private Role role;

    @ManyToOne
    private Company company;

    private Long userId;

    @ManyToOne
    private Team team;

    private String dashboard;
    private String companies;
    private String employee;
    private String customer;
    private String project;
    private String siteVisit;
    private String plotBlocked;
    private String plotBooking;
    private String plotConfirmed;
    private String plotCompleted;
    private String paymentHistory;
    private String reports;
    //Master access
    private String companyModuleForMaster;
    private String employeeModuleForMaster;
    private String teamWiseEmployeeModuleForMaster;
    private String customerModuleForMaster;
    private String projectModuleForMaster;
    private String siteVisitModuleForMaster;
    private String blockModuleForMaster;
    private String BookModuleForMaster;
    private String ConfirmedPlotsForMaster;
    private String PlotsCompletedForMaster;


    //



    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "companyForm", column = @Column(name = "company_form")),
            @AttributeOverride(name = "companyLists", column = @Column(name = "company_lists")),
            @AttributeOverride(name = "companyList.view", column = @Column(name = "company_list_view")),
            @AttributeOverride(name = "companyList.edit", column = @Column(name = "company_list_edit"))
    })
    private CompanyModule companyModule;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "employeeForm", column = @Column(name = "employee_form")),
            @AttributeOverride(name = "employeeLists", column = @Column(name = "employee_lists")),
            @AttributeOverride(name = "employeePrivileges", column = @Column(name = "employee_privileges")),
            @AttributeOverride(name = "employeeTeam", column = @Column(name = "employee_team")),
            @AttributeOverride(name = "employeeTeamLists", column = @Column(name = "employee_team_lists")),
            @AttributeOverride(name = "employeeTeamList.teamEdit", column = @Column(name = "employee_team_list_team_edit")),
            @AttributeOverride(name = "employeeTeamPrivileges", column = @Column(name = "employee_team_privileges")),
            @AttributeOverride(name = "employeeList.view", column = @Column(name = "employee_list_view")),
            @AttributeOverride(name = "employeeList.edit", column = @Column(name = "employee_list_edit"))
    })
    private EmployeeModule employeeModule;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "customerForm", column = @Column(name = "customer_form")),
            @AttributeOverride(name = "customerLists", column = @Column(name = "customer_lists")),
            @AttributeOverride(name = "customerList.view", column = @Column(name = "customer_list_view")),
            @AttributeOverride(name = "customerList.edit", column = @Column(name = "customer_list_edit"))
    })
    private CustomerModule customerModule;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "projectForm", column = @Column(name = "project_form")),
            @AttributeOverride(name = "projectLists", column = @Column(name = "project_lists")),
            @AttributeOverride(name = "projectLayoutLists", column = @Column(name = "project_layout_lists")),
            @AttributeOverride(name = "projectList.view", column = @Column(name = "project_list_view")),
            @AttributeOverride(name = "projectList.edit", column = @Column(name = "project_list_edit")),
            @AttributeOverride(name = "projectLayout.listEdit", column = @Column(name = "project_layout_list_edit"))
    })
    private ProjectModule projectModule;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "siteVisitForm", column = @Column(name = "site_visit_form")),
            @AttributeOverride(name = "siteVisitLists", column = @Column(name = "site_visit_lists")),
            @AttributeOverride(name = "siteVisitList.view", column = @Column(name = "site_visit_list_view")),
            @AttributeOverride(name = "siteVisitList.edit", column = @Column(name = "site_visit_list_edit")),
            @AttributeOverride(name = "siteVisitList.blockBook", column = @Column(name = "site_visit_block_book"))
    })
    private SiteVisitModule siteVisitModule;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "blockedLists", column = @Column(name = "blocked_lists")),
            @AttributeOverride(name = "blockedList.release", column = @Column(name = "blocked_list_release"))
    })
    private BlockedModule blockedModule;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bookingLists", column = @Column(name = "booking_lists")),
            @AttributeOverride(name = "bookingCancelledList", column = @Column(name = "booking_cancelled_list")),
            @AttributeOverride(name = "bookingList.changeCancel", column = @Column(name = "booking_list_change_cancel")),
            @AttributeOverride(name = "bookingList.bookEdit", column = @Column(name = "booking_list_bookEdit"))
    })
    private BookingModule bookingModule;

    @Embeddable
    @Data
    public static class CompanyModule {
        private String companyForm;
        private String companyLists;

        @Embedded
        private PrivilegeAction companyList;
    }

    @Embeddable
    @Data
    public static class EmployeeModule {
        private String employeeForm;
        private String employeeLists;
        private String employeePrivileges;
        private String employeeTeam;
        private String employeeTeamLists;
        private String employeeTeamPrivileges;

        @Embedded
        private PrivilegeAction employeeList;

        @Embedded
        private EmployeeTeamList employeeTeamList;
    }

    @Embeddable
    @Data
    public static class CustomerModule {
        private String customerForm;
        private String customerLists;

        @Embedded
        private PrivilegeAction customerList;
    }

    @Embeddable
    @Data
    public static class ProjectModule {
        private String projectForm;
        private String projectLists;
        private String projectLayoutLists;

        @Embedded
        private PrivilegeAction projectList;
        @Embedded
        private ProjectLayoutAction projectLayout;
    }

    @Embeddable
    @Data
    public static class SiteVisitModule {
        private String siteVisitForm;
        private String siteVisitLists;

        @Embedded
        private SiteVisitAction siteVisitList;
    }

    @Embeddable
    @Data
    public static class BlockedModule {
        private String blockedLists;

        @Embedded
        private BlockedAction blockedList;
    }

    @Embeddable
    @Data
    public static class BookingModule {
        private String bookingLists;
        private String bookingCancelledList;

        @Embedded
        private BookingAction bookingList;
    }

    @Embeddable
    @Data
    public static class PrivilegeAction {
        private String view;
        private String edit;
    }

    @Embeddable
    @Data
    public static class EmployeeTeamList {

        private String teamEdit;
    }

    @Embeddable
    @Data
    public static class ProjectLayoutAction {
        private String listEdit;
    }

    @Embeddable
    @Data
    public static class SiteVisitAction {
        private String view;
        private String edit;
        private String blockBook;
    }

    @Embeddable
    @Data
    public static class BookingAction {
        private String changeCancel;
        private String bookEdit;
    }

    @Embeddable
    @Data
    public static class BlockedAction {
        private String release;
    }

    // Constructor that accepts a Privilege object
    public Privilege(Privilege privilege) {
        this.privilegeId = privilege.getPrivilegeId();
        this.role = privilege.getRole();
        this.company = privilege.getCompany();
        this.userId = privilege.getUserId();
        this.team = privilege.getTeam();
        this.dashboard = privilege.getDashboard();
        this.employeeModule = privilege.getEmployeeModule();
        this.customerModule = privilege.getCustomerModule();
        this.companies = privilege.getCompanies();
        this.employee = privilege.getEmployee();
        this.customer = privilege.getCustomer();
        this.project = privilege.getProject();
        this.siteVisit = privilege.getSiteVisit();
        this.plotBlocked = privilege.getPlotBlocked();
        this.plotBooking = privilege.getPlotBooking();
        this.plotConfirmed = privilege.getPlotConfirmed();
        this.plotCompleted = privilege.getPlotCompleted();
        this.companyModule = privilege.getCompanyModule();
        this.projectModule = privilege.getProjectModule();
        this.siteVisitModule = privilege.getSiteVisitModule();
        this.blockedModule = privilege.getBlockedModule();
        this.bookingModule = privilege.getBookingModule();
        this.paymentHistory = privilege.getPaymentHistory();
        this.reports = privilege.getReports();
    }
}
