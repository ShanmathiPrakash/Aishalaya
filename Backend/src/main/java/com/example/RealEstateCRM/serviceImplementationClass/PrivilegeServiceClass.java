package com.example.RealEstateCRM.serviceImplementationClass;

import com.example.RealEstateCRM.ExceptionHandling.ResourceNotFoundException;
import com.example.RealEstateCRM.model.Employee;
import com.example.RealEstateCRM.model.Privilege;
import com.example.RealEstateCRM.model.Role;
import com.example.RealEstateCRM.model.Team;
import com.example.RealEstateCRM.repository.*;
import com.example.RealEstateCRM.service.PrivilegesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PrivilegeServiceClass implements PrivilegesService {
    @Autowired
    PrivilegeRepository privilegeRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CompanyModelRepository companyRepository;
    @Autowired
    RolesRepository roleRepository;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    TeamRepository teamRepository;


    @Override
    public Privilege generatePrivilege(Privilege privilege) {
        // Validate company
        if (!companyRepository.existsById(privilege.getCompany().getCompanyId())) {
            throw new ResourceNotFoundException("Company Not Found");
        }
        // Handle Team logic
        if (privilege.getTeam() != null && privilege.getTeam().getTeamId() != null) {
            Long teamId = privilege.getTeam().getTeamId();
            if (!teamRepository.existsById(teamId)) {
                throw new ResourceNotFoundException("Team Not Found");
            }
        } else if (privilege.getUserId() != null) {
            Employee employee = employeeRepository.findById(privilege.getUserId()).orElseThrow(
                    () -> new ResourceNotFoundException("Employee Not Found")
            );
            List<Long> teamIds = employee.getTeamId();
            if (teamIds == null || teamIds.isEmpty()) {
                throw new ResourceNotFoundException("No Teams Found for the given Employee");
            }
            Long teamId = teamIds.stream()
                    .filter(id -> id.equals(privilege.getTeam() != null ? privilege.getTeam().getTeamId() : null))
                    .findFirst()
                    .orElseThrow(() -> new ResourceNotFoundException("Provided teamId not found in employee's teamIds"));
            if (privilege.getTeam() == null) {
                privilege.setTeam(new Team());
            }
            privilege.getTeam().setTeamId(teamId);
        } else {
            throw new IllegalArgumentException("Either team or userId must be provided.");
        }

        // Convert status to numbers
        convertStatusToNumber(privilege);

        // Log the privilege data
        System.out.println("Saving privilege: " + privilege);

        if (privilege.getUserId() == null && privilege.getTeam() != null && privilege.getTeam().getTeamId() != null) {
            List<Employee> employees = employeeRepository.findByTeamIdContains(privilege.getTeam().getTeamId());
            for (Employee employee : employees) {
                Privilege newPrivilege = new Privilege(privilege);
                newPrivilege.setUserId(employee.getUserId());

                if (newPrivilege.getRole() == null && employee.getRole() != null) {
                    Role existingRole = roleRepository.findById(employee.getRole().getRoleId()).orElseThrow(
                            () -> new ResourceNotFoundException("Role Not Found")
                    );
                    newPrivilege.setRole(existingRole);
                }

                Privilege existingPrivilege = privilegeRepository.findByCompanyCompanyIdAndUserId(
                        privilege.getCompany().getCompanyId(), newPrivilege.getUserId());

                if (existingPrivilege == null) {
                    Privilege savedPrivilege = privilegeRepository.save(newPrivilege);
                    System.out.println("Saved new privilege for userId: " + savedPrivilege.getUserId());
                } else {
                    updatePrivilege(existingPrivilege, newPrivilege);
                    Privilege updatedPrivilege = privilegeRepository.save(existingPrivilege);
                    System.out.println("Updated existing privilege for userId: " + updatedPrivilege.getUserId());
                }
            }
        } else {
            Privilege existingPrivilege = privilegeRepository.findByCompanyCompanyIdAndUserId(
                    privilege.getCompany().getCompanyId(), privilege.getUserId());

            if (existingPrivilege == null) {
                if (privilege.getUserId() != null) {
                    Employee employee = employeeRepository.findById(privilege.getUserId()).orElseThrow(
                            () -> new ResourceNotFoundException("Employee Not Found")
                    );
                    if (employee.getRole() != null) {
                        Role existingRole = roleRepository.findById(employee.getRole().getRoleId()).orElseThrow(
                                () -> new ResourceNotFoundException("Role Not Found")
                        );
                        privilege.setRole(existingRole);
                    }
                }
                Privilege savedPrivilege = privilegeRepository.save(privilege);
                System.out.println("Saved new privilege for userId: " + savedPrivilege.getUserId());
                return savedPrivilege;
            } else {
                if (privilege.getUserId() != null) {
                    Employee employee = employeeRepository.findById(privilege.getUserId()).orElseThrow(
                            () -> new ResourceNotFoundException("Employee Not Found")
                    );
                    if (employee.getRole() != null) {
                        Role existingRole = roleRepository.findById(employee.getRole().getRoleId()).orElseThrow(
                                () -> new ResourceNotFoundException("Role Not Found")
                        );
                        existingPrivilege.setRole(existingRole);
                    }
                }
                updatePrivilege(existingPrivilege, privilege);
                Privilege updatedPrivilege = privilegeRepository.save(existingPrivilege);
                System.out.println("Updated existing privilege for userId: " + updatedPrivilege.getUserId());
                return updatedPrivilege;
            }
        }

        return privilege;
    }
    @Transactional(readOnly = true)
    public List<String> getActivePriviledgeColumnsForMultipleRoles(String emailId) {
        Set<String> activePrivilegeColumnsSet = new LinkedHashSet<>();
        Employee employee = employeeRepository.findByEmployeeEmail(emailId);


        if (employee != null) {
            List<Long> teamIds = employee.getTeamId(); // Fetch eagerly configured

            if (employee.getUserId() != null && teamIds != null && !teamIds.isEmpty()) {
                List<Privilege> privileges = privilegeRepository.findByCompanyCompanyIdAndUserIdAndTeamTeamIdIn(
                        employee.getCompany().getCompanyId(), employee.getUserId(), teamIds);

                if (!privileges.isEmpty()) {
                    for (Privilege priv : privileges) {
                        activePrivilegeColumnsSet.addAll(filterActivePrivilegeColumns(priv));
                    }
                } else {
                    throw new ResourceNotFoundException("Privilege Not Found for userId: " + employee.getUserId() + " and teamIds: " + teamIds);
                }
            } else {
                throw new ResourceNotFoundException("Invalid Privilege configuration: Both userId and teamIds are required.");
            }
        } else {
            throw new ResourceNotFoundException("Employee Not Found for email: " + emailId);
        }
System.out.println("arrayList:"+activePrivilegeColumnsSet);
        return new ArrayList<>(activePrivilegeColumnsSet);

    }


    private void updatePrivilege(Privilege existingPrivilege, Privilege newPrivilege) {
        // Update existing privilege's properties with new privilege values
        existingPrivilege.setDashboard(newPrivilege.getDashboard());
        existingPrivilege.setCompanies(newPrivilege.getCompanies());
        existingPrivilege.setEmployee(newPrivilege.getEmployee());
        existingPrivilege.setCustomer(newPrivilege.getCustomer());
        existingPrivilege.setProject(newPrivilege.getProject());
        existingPrivilege.setSiteVisit(newPrivilege.getSiteVisit());
        existingPrivilege.setPlotBlocked(newPrivilege.getPlotBlocked());
        existingPrivilege.setPlotBooking(newPrivilege.getPlotBooking());
        existingPrivilege.setPlotConfirmed(newPrivilege.getPlotConfirmed());
        existingPrivilege.setPlotCompleted(newPrivilege.getPlotCompleted());
        existingPrivilege.setPaymentHistory(newPrivilege.getPaymentHistory());
        existingPrivilege.setReports(newPrivilege.getReports());
        existingPrivilege.setCompanyModule(newPrivilege.getCompanyModule());
        existingPrivilege.setEmployeeModule(newPrivilege.getEmployeeModule());
        existingPrivilege.setCustomerModule(newPrivilege.getCustomerModule());
        existingPrivilege.setProjectModule(newPrivilege.getProjectModule());
        existingPrivilege.setSiteVisitModule(newPrivilege.getSiteVisitModule());
        existingPrivilege.setBlockedModule(newPrivilege.getBlockedModule());
        existingPrivilege.setBookingModule(newPrivilege.getBookingModule());

    }






    private Set<String> filterActivePrivilegeColumns(Privilege privilege) {
        Set<String> activeColumns = new LinkedHashSet<>();

        // Check each column and add it to the active columns set if "1"
        addActiveColumn(activeColumns, privilege.getDashboard(), "Dashboard");
        addActiveColumn(activeColumns, privilege.getCompanies(), "Companies");
        addActiveColumn(activeColumns, privilege.getEmployee(), "Employee");
        addActiveColumn(activeColumns, privilege.getCustomer(), "Customer");
        addActiveColumn(activeColumns, privilege.getProject(), "Project");
        addActiveColumn(activeColumns, privilege.getSiteVisit(), "Site Visit");
        addActiveColumn(activeColumns, privilege.getPlotBlocked(), "PlotBlocked");
        addActiveColumn(activeColumns, privilege.getPlotBooking(), "PlotBooking");
        addActiveColumn(activeColumns, privilege.getPlotConfirmed(), "Plot Confirmed");
        addActiveColumn(activeColumns, privilege.getPlotCompleted(), "Plot Completed");
        addActiveColumn(activeColumns, privilege.getPaymentHistory(), "Payment History");
        addActiveColumn(activeColumns, privilege.getReports(), "Reports");
       //master acces
        addActiveColumn(activeColumns, privilege.getCompanyModuleForMaster(), "Company Module");
        addActiveColumn(activeColumns, privilege.getEmployeeModuleForMaster(), "Employee Module");
        addActiveColumn(activeColumns, privilege.getTeamWiseEmployeeModuleForMaster(), "Team Employee Module");
        addActiveColumn(activeColumns, privilege.getCustomerModuleForMaster(), "Customer Module");
        addActiveColumn(activeColumns, privilege.getProjectModuleForMaster(), "Project Module");
         addActiveColumn(activeColumns, privilege.getSiteVisitModuleForMaster(), "Site Visit Module");
        addActiveColumn(activeColumns, privilege.getBlockModuleForMaster(), "Block Module");
        addActiveColumn(activeColumns, privilege.getBookModuleForMaster(), "Booking Module");
        addActiveColumn(activeColumns, privilege.getConfirmedPlotsForMaster(), "Confirmed Plots");
        addActiveColumn(activeColumns, privilege.getPlotsCompletedForMaster(), "Plots Completed");



        // Check CompanyModule for "Active" status
        if (privilege.getCompanyModule() != null) {
            addActiveColumn(activeColumns, privilege.getCompanyModule().getCompanyForm(), "Company Form");
            addActiveColumn(activeColumns, privilege.getCompanyModule().getCompanyLists(), "Company Lists");
            addActiveColumn(activeColumns, privilege.getCompanyModule().getCompanyList().getView(), "Company List View");
            addActiveColumn(activeColumns, privilege.getCompanyModule().getCompanyList().getEdit(), "Company List Edit");
        }

        // Check EmployeeModule for "Active" status
        if (privilege.getEmployeeModule() != null) {
            addActiveColumn(activeColumns, privilege.getEmployeeModule().getEmployeeForm(), "Employee Form");
            addActiveColumn(activeColumns, privilege.getEmployeeModule().getEmployeeLists(), "Employee Lists");
            addActiveColumn(activeColumns, privilege.getEmployeeModule().getEmployeePrivileges(), "Employee Privileges");
            addActiveColumn(activeColumns, privilege.getEmployeeModule().getEmployeeTeam(), "Employee Team");
            addActiveColumn(activeColumns, privilege.getEmployeeModule().getEmployeeTeamLists(), "Employee Team Lists");
            addActiveColumn(activeColumns, privilege.getEmployeeModule().getEmployeeTeamList().getTeamEdit(), "Employee Team List Team Edit");
            addActiveColumn(activeColumns, privilege.getEmployeeModule().getEmployeeTeamPrivileges(), "Employee Team Privileges");
            addActiveColumn(activeColumns, privilege.getEmployeeModule().getEmployeeList().getView(), "Employee List View");
            addActiveColumn(activeColumns, privilege.getEmployeeModule().getEmployeeList().getEdit(), "Employee List Edit");
        }

        // Check CustomerModule for "Active" status
        if (privilege.getCustomerModule() != null) {
            addActiveColumn(activeColumns, privilege.getCustomerModule().getCustomerForm(), "Customer Form");
            addActiveColumn(activeColumns, privilege.getCustomerModule().getCustomerLists(), "Customer Lists");
            addActiveColumn(activeColumns, privilege.getCustomerModule().getCustomerList().getView(), "Customer List View");
            addActiveColumn(activeColumns, privilege.getCustomerModule().getCustomerList().getEdit(), "Customer List Edit");
        }

        // Check ProjectModule for "Active" status
        if (privilege.getProjectModule() != null) {
            addActiveColumn(activeColumns, privilege.getProjectModule().getProjectForm(), "Project Form");
            addActiveColumn(activeColumns, privilege.getProjectModule().getProjectLists(), "Project Lists");
            addActiveColumn(activeColumns, privilege.getProjectModule().getProjectLayoutLists(), "Project Layout Lists");
            addActiveColumn(activeColumns, privilege.getProjectModule().getProjectList().getView(), "Project List View");
            addActiveColumn(activeColumns, privilege.getProjectModule().getProjectList().getEdit(), "Project List Edit");
            addActiveColumn(activeColumns, privilege.getProjectModule().getProjectLayout().getListEdit(), "Project Layout ListEdit");
        }

        // Check SiteVisitModule for "Active" status
        if (privilege.getSiteVisitModule() != null) {
            addActiveColumn(activeColumns, privilege.getSiteVisitModule().getSiteVisitForm(), "Site Visit Form");
            addActiveColumn(activeColumns, privilege.getSiteVisitModule().getSiteVisitLists(), "Site Visit Lists");
            addActiveColumn(activeColumns, privilege.getSiteVisitModule().getSiteVisitList().getView(), "Site Visit List View");
            addActiveColumn(activeColumns, privilege.getSiteVisitModule().getSiteVisitList().getEdit(), "Site Visit List Edit");
            addActiveColumn(activeColumns, privilege.getSiteVisitModule().getSiteVisitList().getBlockBook(), "Site Visit List BlockBook");
        }

        if (privilege.getBlockedModule() != null) {
            addActiveColumn(activeColumns, privilege.getBlockedModule().getBlockedLists(), "Blocked Lists");
            addActiveColumn(activeColumns, privilege.getBlockedModule().getBlockedList().getRelease(), "BlockedList Release");
        }

        if (privilege.getBookingModule() != null) {
            addActiveColumn(activeColumns, privilege.getBookingModule().getBookingLists(), "Booking Lists");
            addActiveColumn(activeColumns, privilege.getBookingModule().getBookingCancelledList(), "Booking Cancelled List");
            addActiveColumn(activeColumns, privilege.getBookingModule().getBookingList().getChangeCancel(), "Booking List ChangeCancel");
        }

        return activeColumns;
    }



    private void addActiveColumn(Set<String> activeColumns, String status, String columnName) {
        if ("1".equals(status)) {
            activeColumns.add(columnName);
        }
    }

    private void convertStatusToNumber(Privilege privilege) {

        privilege.setDashboard(convertStatus(privilege.getDashboard()));
        privilege.setCompanies(convertStatus(privilege.getCompanies()));
        privilege.setEmployee(convertStatus(privilege.getEmployee()));
        privilege.setCustomer(convertStatus(privilege.getCustomer()));
        privilege.setProject(convertStatus(privilege.getProject()));
        privilege.setSiteVisit(convertStatus(privilege.getSiteVisit()));
        privilege.setPlotBlocked(convertStatus(privilege.getPlotBlocked()));
        privilege.setPlotBooking(convertStatus(privilege.getPlotBooking()));
        privilege.setPlotConfirmed(convertStatus(privilege.getPlotConfirmed()));
        privilege.setPlotCompleted(convertStatus(privilege.getPlotCompleted()));
        privilege.setPaymentHistory(convertStatus(privilege.getPaymentHistory()));
        privilege.setReports(convertStatus(privilege.getReports()));

        if (privilege.getCompanyModule() != null) {
            privilege.getCompanyModule().setCompanyForm(convertStatus(privilege.getCompanyModule().getCompanyForm()));
            privilege.getCompanyModule().setCompanyLists(convertStatus(privilege.getCompanyModule().getCompanyLists()));
            privilege.getCompanyModule().getCompanyList().setView(convertStatus(privilege.getCompanyModule().getCompanyList().getView()));
            privilege.getCompanyModule().getCompanyList().setEdit(convertStatus(privilege.getCompanyModule().getCompanyList().getEdit()));
        }

        if (privilege.getEmployeeModule() != null) {
            privilege.getEmployeeModule().setEmployeeForm(convertStatus(privilege.getEmployeeModule().getEmployeeForm()));
            privilege.getEmployeeModule().setEmployeeLists(convertStatus(privilege.getEmployeeModule().getEmployeeLists()));
            privilege.getEmployeeModule().setEmployeePrivileges(convertStatus(privilege.getEmployeeModule().getEmployeePrivileges()));
            privilege.getEmployeeModule().setEmployeeTeam(convertStatus(privilege.getEmployeeModule().getEmployeeTeam()));
            privilege.getEmployeeModule().setEmployeeTeamLists(convertStatus(privilege.getEmployeeModule().getEmployeeTeamLists()));
            privilege.getEmployeeModule().getEmployeeTeamList().setTeamEdit(convertStatus(privilege.getEmployeeModule().getEmployeeTeamList().getTeamEdit()));
            privilege.getEmployeeModule().setEmployeeTeamPrivileges(convertStatus(privilege.getEmployeeModule().getEmployeeTeamPrivileges()));
            privilege.getEmployeeModule().getEmployeeList().setView(convertStatus(privilege.getEmployeeModule().getEmployeeList().getView()));
            privilege.getEmployeeModule().getEmployeeList().setEdit(convertStatus(privilege.getEmployeeModule().getEmployeeList().getEdit()));
        }

        if (privilege.getCustomerModule() != null) {
            privilege.getCustomerModule().setCustomerForm(convertStatus(privilege.getCustomerModule().getCustomerForm()));
            privilege.getCustomerModule().setCustomerLists(convertStatus(privilege.getCustomerModule().getCustomerLists()));
            privilege.getCustomerModule().getCustomerList().setView(convertStatus(privilege.getCustomerModule().getCustomerList().getView()));
            privilege.getCustomerModule().getCustomerList().setEdit(convertStatus(privilege.getCustomerModule().getCustomerList().getEdit()));
        }



        if (privilege.getProjectModule() != null) {
            privilege.getProjectModule().setProjectForm(convertStatus(privilege.getProjectModule().getProjectForm()));
            privilege.getProjectModule().setProjectLists(convertStatus(privilege.getProjectModule().getProjectLists()));
            privilege.getProjectModule().setProjectLayoutLists(convertStatus(privilege.getProjectModule().getProjectLayoutLists()));
            privilege.getProjectModule().getProjectList().setView(convertStatus(privilege.getProjectModule().getProjectList().getView()));
            privilege.getProjectModule().getProjectList().setEdit(convertStatus(privilege.getProjectModule().getProjectList().getEdit()));
            privilege.getProjectModule().getProjectLayout().setListEdit(convertStatus(privilege.getProjectModule().getProjectLayout().getListEdit()));
        }

        if (privilege.getSiteVisitModule() != null) {
            privilege.getSiteVisitModule().setSiteVisitForm(convertStatus(privilege.getSiteVisitModule().getSiteVisitForm()));
            privilege.getSiteVisitModule().setSiteVisitLists(convertStatus(privilege.getSiteVisitModule().getSiteVisitLists()));
            privilege.getSiteVisitModule().getSiteVisitList().setView(convertStatus(privilege.getSiteVisitModule().getSiteVisitList().getView()));
            privilege.getSiteVisitModule().getSiteVisitList().setEdit(convertStatus(privilege.getSiteVisitModule().getSiteVisitList().getEdit()));
            privilege.getSiteVisitModule().getSiteVisitList().setBlockBook(convertStatus(privilege.getSiteVisitModule().getSiteVisitList().getBlockBook()));

        }

        if (privilege.getBlockedModule() != null) {
            privilege.getBlockedModule().setBlockedLists(convertStatus(privilege.getBlockedModule().getBlockedLists()));
            privilege.getBlockedModule().getBlockedList().setRelease(convertStatus(privilege.getBlockedModule().getBlockedList().getRelease()));
        }

        if (privilege.getBookingModule() != null) {
            privilege.getBookingModule().setBookingLists(convertStatus(privilege.getBookingModule().getBookingLists()));
            privilege.getBookingModule().setBookingCancelledList(convertStatus(privilege.getBookingModule().getBookingCancelledList()));
            privilege.getBookingModule().getBookingList().setChangeCancel(convertStatus(privilege.getBookingModule().getBookingList().getChangeCancel()));
            privilege.getBookingModule().getBookingList().setBookEdit(convertStatus(privilege.getBookingModule().getBookingList().getBookEdit()));
        }
    }

    private String convertStatus(String status) {
        if ("Active".equalsIgnoreCase(status)) {
            return "1";
        } else if ("Inactive".equalsIgnoreCase(status)) {
            return "0";
        } else {
            return status; // return the original status if it is neither "Active" nor "Inactive"
        }
    }

}
