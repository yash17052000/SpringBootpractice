package com.example.Crud.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeSalaryDetails {
    @Id
    @GeneratedValue
    Integer id;
    String name;
    int salary;
}
