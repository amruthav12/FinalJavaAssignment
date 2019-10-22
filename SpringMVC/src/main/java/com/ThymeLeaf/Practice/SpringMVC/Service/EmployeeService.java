package com.ThymeLeaf.Practice.SpringMVC.Service;

import com.ThymeLeaf.Practice.SpringMVC.Entity.Employee;
import com.ThymeLeaf.Practice.SpringMVC.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    //Dependency Injection
    @Autowired
    EmployeeRepository repository ;
    //read - returns list of all the employee
    public List <Employee> getAllEmployees(){
         List <Employee> result = (List <Employee>)repository.findAll();
         if (result.size()>0){
             return result;
        }
         else{
             //Array list implements list
             return new ArrayList<Employee>();
         }
    }
    //findbyid
    public Employee getEmployeeById(Long id)  throws Exception{
    Optional <Employee> emp = repository.findById(id);
    if (emp.isPresent() ){
        return emp.get();
    }
    else{
        throw new Exception();
    }
    }

    //post - write into the database also update
    public Employee CreateOrUpdate(Employee entity){
        if(entity.getId() == -1){
            entity = repository.save(entity);
            return entity;
        }else{
            Optional<Employee> emp = repository.findById(entity.getId());
            if(emp.isPresent()){
                Employee e = emp.get();
                e.setEmail(entity.getEmail());
                e.setFirstName(entity.getFirstName());
                e.setLastName(entity.getLastName());
                e = repository.save(e);
                return e;
            }else{
                entity = repository.save(entity);
                return entity;
            }
        }
    }

    //delete
    public void deleteEmployeeById(Long id) throws Exception{
    Optional<Employee> emp = repository.findById(id);
    if(emp.isPresent()){
        repository.deleteById(id);
    }else{
        throw new Exception("No record found");
    }
}

}
