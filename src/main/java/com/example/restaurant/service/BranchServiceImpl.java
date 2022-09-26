package com.example.restaurant.service;

import com.example.restaurant.model.Branch;
import com.example.restaurant.repository.BranchRepository;
import org.springframework.stereotype.Service;
@Service
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public Branch create(String name) throws BranchAlreadyExistsException {
        checkIfBranchAlreadyExists(name);

        return branchRepository.save(new Branch(name));
    }
    private void checkIfBranchAlreadyExists(String name) {
        branchRepository.findAll()
                        .forEach(branchModel -> {
                            if (branchModel.getName()
                                           .equals(name)) {
                                throw new BranchAlreadyExistsException();
                            }
                        });
    }

    @Override
    public long count() {
        return branchRepository.count();
    }

    @Override
    public Branch getById(long id) throws BranchNotFoundException {
        return branchRepository.findById(id)
                               .orElseThrow(BranchNotFoundException::new);
    }

    public static class BranchNotFoundException extends RuntimeException {

    }
    public static class BranchAlreadyExistsException extends RuntimeException {
    }
}
