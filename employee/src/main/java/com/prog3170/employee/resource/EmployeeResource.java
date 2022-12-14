package com.prog3170.employee.resource;

import com.prog3170.employee.persistence.Employee;
import com.prog3170.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeResource {
    private final EmployeeService service;

    public EmployeeResource(EmployeeService service) {
        this.service = service;
    }

    @GetMapping(value = "/employees")
    public List<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/employees/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping(value = "/employees")
    public Employee add(Employee employee) {
        return service.add(employee);
    }

    @PutMapping(value = "/employees/{id}", consumes = "application/json")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee) throws Exception {
        return service.update(id, employee);
    }

    @DeleteMapping(value = "/employees/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
