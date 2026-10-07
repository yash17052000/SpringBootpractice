package com.example.Crud.Repository;

import com.example.Crud.Entity.Employee;
import com.example.Crud.Entity.EmployeeSalaryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDetailsRepository extends JpaRepository<Employee,Integer> {

   Employee save(Employee employee);

    @Query(value = "SELECT * FROM employee_details", nativeQuery = true)
    List<Employee> getAll();
}
