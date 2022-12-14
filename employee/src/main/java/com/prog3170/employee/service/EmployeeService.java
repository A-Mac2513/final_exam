package com.prog3170.employee.service;

import com.prog3170.employee.persistence.Employee;
import com.prog3170.employee.persistence.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> getAll(){
        return this.repo.findAll();
    }

    public Employee getById(Long id){
        return this.repo.findById(id).get();
    }

    public Employee add(Employee employee) {
        return this.repo.save(employee);
    }

    public Employee update (Long id, Employee employee) {
        Optional<Employee> emp = this.repo.findById(id);
        if (emp.isPresent()) {
            emp.get().setName(employee.getName());
            emp.get().setEmail(employee.getEmail());
            emp.get().setPassword(employee.getPassword());
            emp.get().setPhone(employee.getPhone());
            return this.repo.save(emp.get());
        }
        else {
            throw new RuntimeException();
        }
    }

    public void delete(Long id){
        this.repo.deleteById(id);
    }
}
