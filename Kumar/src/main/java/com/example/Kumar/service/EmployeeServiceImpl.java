package com.example.Kumar.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.example.Kumar.entity.Employee;
import com.example.Kumar.repo.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> listEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee fetchEmployeeById(Long employeeID) {
        return employeeRepository.findById(employeeID).orElse(null);
    }

    @Override
    public String deleteEmployee(Long employeeID) {
        employeeRepository.deleteById(employeeID);
        return "Employee deleted successfully!";
    }

    @Override
    public Employee editEmployee(Long employeeID, Employee employee) {
        Optional<Employee> empOptional = employeeRepository.findById(employeeID);
        if (empOptional.isPresent()) {
            Employee emp = empOptional.get();
            emp.setEmployeeFirstName(employee.getEmployeeFirstName());
            emp.setEmployeeLastName(employee.getEmployeeLastName());
            emp.setEmployeePhone(employee.getEmployeePhone());
            emp.setEmployeeLocation(employee.getEmployeLocation());       
            emp.setEmployeeEmail(employee.getEmployeeEmail());
            return employeeRepository.save(emp);
        }
        return null;
    }
}