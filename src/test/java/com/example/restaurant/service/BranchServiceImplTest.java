package com.example.restaurant.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
public class BranchServiceImplTest {
    @Autowired
    private BranchService branchService;

    @Test
    public void createShouldSaveBranch() {
        var countBranches = branchService.count();
        var branch = branchService.create("test");
        assertThat(branchService.count()).isGreaterThan(countBranches);
        assertEquals(branch.getName(),
                     "test");
    }

    @Test
    public void createShouldThrowBranchAlreadyExistsException() {

        assertThrows(BranchServiceImpl.BranchAlreadyExistsException.class,
                     () -> branchService.create("test"));
    }

    @Test
    public void createShouldReturnBranch() {
        var branch = branchService.create("Mac");
        assertEquals(branch,
                     branchService.getById(branch.getId()));
    }

    @Test
    public void findByIdShouldThrowBranchNotFoundException() {
        assertThrows(BranchServiceImpl.BranchNotFoundException.class,
                     () -> branchService.getById(23123));
    }

    @Test
    public void findByIdShouldReturnBranch() throws BranchServiceImpl.BranchNotFoundException {
        var branch = branchService.create("Braseiro");
        assertEquals(branch,
                     branchService.getById(branch.getId()));
    }
}

