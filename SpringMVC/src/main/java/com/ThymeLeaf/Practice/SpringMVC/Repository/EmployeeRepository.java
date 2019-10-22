package com.ThymeLeaf.Practice.SpringMVC.Repository;

import com.ThymeLeaf.Practice.SpringMVC.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee,Long>{


}
