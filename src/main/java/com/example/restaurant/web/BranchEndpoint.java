package com.example.restaurant.web;

import com.example.restaurant.model.BranchModel;
import com.example.restaurant.service.modelService.BranchService;
import com.example.restaurant.service.modelService.BranchServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping (value = "/branch", path = "/branch")
public class BranchEndpoint {
    BranchService branchService;

    public BranchEndpoint(BranchService branchService) {
        this.branchService = branchService;
    }

    @PostMapping ("/create")
    public BranchModel create(@RequestBody BranchModel branchModel) {
        return branchService.create(branchModel.getName());
    }

    @GetMapping ("/count")
    public long count() {
        return branchService.count();
    }

    @GetMapping ("/{id}")
    public BranchModel getById(@PathVariable long id) throws BranchServiceImpl.BranchNotFoundException {
        return branchService.getById(id);
    }

}
