package com.example.Crud.Service;

import com.example.Crud.Entity.Employee;
import com.example.Crud.Entity.EmployeeSalaryDetails;
import com.example.Crud.Repository.EmployeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDetailsRepository employeeDetailsRepository;

    EmployeeSalaryDetails employeeSalaryDetails= new EmployeeSalaryDetails();
    public EmployeeSalaryDetails addEmployee(Employee employee) {

        Employee employee1 = employeeDetailsRepository.save(employee);



        employeeSalaryDetails.setSalary(employee1.getSalary());
        employeeSalaryDetails.setName(employee1.getName());

        return employeeSalaryDetails;
    }
    public List<EmployeeSalaryDetails> getALlEMployees(){
     List<Employee> list = employeeDetailsRepository.getAll();
      return  list.stream().map((x)->{

            return new EmployeeSalaryDetails(UUID.randomUUID().variant(), x.getName(),x.getSalary());
        }).collect(Collectors.toList());
    }

}