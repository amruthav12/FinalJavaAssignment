package com.ThymeLeaf.Practice.SpringMVC.Controller;

import com.ThymeLeaf.Practice.SpringMVC.Entity.Employee;
import com.ThymeLeaf.Practice.SpringMVC.Service.EmployeeService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @RequestMapping ("/api")
    public String getAllEmp(Model model){
        List<Employee> ls = service.getAllEmployees();
        model.addAttribute("Employee",ls);
        return "EmployeeList";
    }
    //get mapping for editing the employees by id
    @RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
    public String CreateOrUpdate(Employee emp){
        service.CreateOrUpdate(emp);
        return "redirect:/api"; // to the same place we are working.
    }

    @RequestMapping(path = {"/edit","/edit/{id}"})
    public String getEmployeeByID(Model model, @PathVariable("id") Optional<Long> idop) throws Exception {
        if(idop.isPresent()){
            Employee emp =service.getEmployeeById(idop.get());
            model.addAttribute("employee",emp);
        }else{
            model.addAttribute("employee",new Employee());

        }
        return "add-edit";
    }

    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) throws Exception{
        service.deleteEmployeeById(id);
        return "redirect:/api";
    }
}
