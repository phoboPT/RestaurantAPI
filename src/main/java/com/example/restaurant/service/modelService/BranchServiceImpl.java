package com.example.restaurant.service.modelService;

import com.example.restaurant.model.BranchModel;
import com.example.restaurant.repository.BranchRepository;
import org.springframework.stereotype.Service;
@Service
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public BranchModel create(String name) throws BranchAlreadyExistsException {
        checkIfBranchAlreadyExists(name);

        return branchRepository.save(new BranchModel(name));
    }
    private void checkIfBranchAlreadyExists(String name) {
        branchRepository.findAll().forEach(branchModel -> {
            if (branchModel.getName().equals(name)) {
                throw new BranchAlreadyExistsException();
            }
        });
    }

    @Override
    public long count() {
        return branchRepository.count();
    }

    @Override
    public BranchModel getById(long id) throws BranchNotFoundException {
        return branchRepository.findById(id).orElseThrow(BranchNotFoundException::new);
    }

    public static class BranchNotFoundException extends RuntimeException {

    }
    public static class BranchAlreadyExistsException extends RuntimeException {
    }
}
