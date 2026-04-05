package com.ninthfeb.dummy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImp implements EmpService {
    @Autowired
    private EmpReposistory empReposistory;
    //List<Employee> employees = new ArrayList<>();
    
    
    @Override
    public List<Employee> readEmployees() {
        List<EmpEntity> empList = empReposistory.findAll();
        List<Employee> employees = new ArrayList<>();
        for (EmpEntity empEntity : empList) {

            Employee employee = new Employee();
            BeanUtils.copyProperties(empEntity, employee);

            employees.add(employee);
        }
        return employees;
    }

    @Override
    public String createEmployee(Employee employee) {
        EmpEntity empEntity = new EmpEntity();
        BeanUtils.copyProperties(employee, empEntity);
        empReposistory.save(empEntity);
        //employees.add(employee);
        return "saved successfully";
    }

    @Override
    public boolean deleteEmployee(Long id) {
           empReposistory.deleteById(id);
           return true;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmpEntity empEntity = empReposistory.findById(id).orElse(null);
        if(empEntity == null)
            return "not found";
        BeanUtils.copyProperties(employee, empEntity, "id");
        empReposistory.save(empEntity);
        return "updated successfully";
    }

    @Override
    public Employee readEmployeeById(Long id) {
        EmpEntity empEntity= empReposistory.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(empEntity, employee);
        return employee;
    }

    @Override
    public Employee readEmployeeByName(String name) {
        EmpEntity empEntity = empReposistory.findByName(name).get(0);
        if (empEntity == null) {
            return null; // or throw exception
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(empEntity, employee);
        return employee;
    }

}
