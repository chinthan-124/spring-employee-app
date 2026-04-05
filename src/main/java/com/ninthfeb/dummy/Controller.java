package com.ninthfeb.dummy;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class Controller {

  //DependencyInjection
  //EmpService empService = new EmpServiceImp();
   @Autowired
   EmpService empService;
    @GetMapping("employee")
     public List <Employee> getEmployees() {
       return empService.readEmployees();
    }

    @GetMapping("employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
      return empService.readEmployeeById(id);
    }

    @GetMapping("employee/name/{name}")
    public Employee getEmployeeByName(@PathVariable String name) {
      return empService.readEmployeeByName(name);
    }
    

    @PostMapping("employee")
    public String createEmployee(@RequestBody Employee employee){
      return empService.createEmployee(employee);
    }

    @DeleteMapping("employee/{id}")
    public String deleteEmployee(@PathVariable Long id){
      if(empService.deleteEmployee(id))
        return "deleted successfully";
      return "not found";
    }
    @PutMapping("employee/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return empService.updateEmployee(id, employee);
    }
  }