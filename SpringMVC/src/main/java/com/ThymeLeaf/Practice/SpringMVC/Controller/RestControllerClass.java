package com.ThymeLeaf.Practice.SpringMVC.Controller;


import com.ThymeLeaf.Practice.SpringMVC.Entity.Employee;
import com.ThymeLeaf.Practice.SpringMVC.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api2")
public class RestControllerClass {
    @Autowired
    EmployeeService service;

    //GET
    @GetMapping("/api")
    public List <Employee> getAllEmp(){
        List<Employee> ls = service.getAllEmployees();
       // model.addAttribute("Employee",ls);
        return ls;
    }
    //post
    //get mapping for editing the employees by id
    @PostMapping(path = "/createEmployee")
    public Employee CreateOrUpdate(@Valid @RequestBody Employee emp){
        service.CreateOrUpdate(emp);
        return emp; // to the same place we are working.
    }

    @PutMapping(path = {"/edit","/edit/{id}"})
    public Employee getEmployeeByID(@PathVariable("id") Optional<Long> idop) throws Exception {
        if(idop.isPresent()){
            Employee emp =service.getEmployeeById(idop.get());
            return emp;
        }else{
            return new Employee();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) throws Exception{
        service.deleteEmployeeById(id);
        return ResponseEntity.ok().build();
    }
}



