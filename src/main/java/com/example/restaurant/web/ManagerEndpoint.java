package com.example.restaurant.web;

import com.example.restaurant.model.Employee;
import com.example.restaurant.model.Manager;
import com.example.restaurant.service.ManagerService;
import com.example.restaurant.service.ManagerServiceImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping (value = "/manager", path = "/manager")
@RestController
public class ManagerEndpoint {

    private final ManagerService managerService;

    public ManagerEndpoint(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping ("/create")
    public Manager create(@RequestBody Manager manager) {
        return managerService.create(manager.getName(), manager.getAccount(), manager.getEmail(), manager.getPhone());
    }

    @PostMapping ("/addEmployee/{type}")
    public Employee addEmployee(@RequestBody @NotNull Employee employee, @PathVariable String type) {
        return managerService.addEmployee(employee.getName(), employee.getAccount(), employee.getEmail(),
                                          employee.getPhone(), type);

    }

    @GetMapping ("/count")
    public long count() {
        return managerService.count();
    }

    @GetMapping ("/{id}")
    public Manager getById(@PathVariable long id) throws ManagerServiceImpl.ManagerNotFoundException {
        return managerService.getById(id);
    }

}
