package com.example.Crud.controller;


import com.example.Crud.Entity.Employee;
import com.example.Crud.Entity.EmployeeSalaryDetails;
import com.example.Crud.Exception.UserNotFoundException;
import com.example.Crud.Service.EmployeeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private static final Log log = LogFactory.getLog(EmployeeController.class);
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/add")
public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        if(authentication.isAuthenticated())
            log.info(authentication);
    return new ResponseEntity<>(employeeService.addEmployee(employee),
            HttpStatus.ACCEPTED
            );
}

@GetMapping
public  String getName(){

        return  "Yash1s";
}

@GetMapping("/getAll")
public ResponseEntity<?> getAllEmployees() {
 Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
 if(authentication.isAuthenticated())
    log.info(authentication);
    List<EmployeeSalaryDetails> aLlEMployees =
            employeeService.getALlEMployees();

    if (aLlEMployees.size() == 0) {
        throw new UserNotFoundException("Not found");
    }

    return new ResponseEntity<>(aLlEMployees, HttpStatus.OK);
}
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(
            UserNotFoundException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
}
