package com.example.RealEstateCRM.repository;

import com.example.RealEstateCRM.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = "SELECT MAX(e.customerId) FROM Customer e")
    Long findMaxCustomerId();
    Optional<Customer> findByCustomerNameAndMobileNumberAndEmployeeCode(String customerName, String mobileNumber, String employeeCode);
    Optional<Customer> findByMobileNumber(String mobileNumber);
    Customer findByCustomerEmail(String customerEmail);

    List<Customer> findByCompanyId(Long companyId);

    List<Customer> findByCompanyIdAndTeamIdIn(Long companyId, List<Long> teamId);
}
