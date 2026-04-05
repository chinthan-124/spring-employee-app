package com.ninthfeb.dummy;

import java.util.List;

public interface EmpService {
    public List <Employee> readEmployees();
    String createEmployee(Employee employee);
    boolean deleteEmployee(Long id);
    String updateEmployee(Long id, Employee employee);
    public Employee readEmployeeById(Long id);
    public Employee readEmployeeByName(String name);
}
