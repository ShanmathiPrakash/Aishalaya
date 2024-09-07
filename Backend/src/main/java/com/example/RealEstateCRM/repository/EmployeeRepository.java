package com.example.RealEstateCRM.repository;

import com.example.RealEstateCRM.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByEmployeeName(String employeeName);
//    Employee findByDesignation(String designation);
    @Query(value = "SELECT MAX(e.employeeId) FROM Employee e")
    Long findMaxEmployeeId();

    Employee findByEmployeeEmail(String emailId);

    List<Employee> findByEmployeeNameIn(List<String> names);



    List<Employee> findByTeamIdContains(Long teamId);


    List<Employee> findByCompanyCompanyId(Long companyId);
}
