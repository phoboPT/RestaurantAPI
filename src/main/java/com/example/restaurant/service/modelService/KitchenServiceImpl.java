package com.example.restaurant.service.modelService;

import com.example.restaurant.model.KitchenModel;
import com.example.restaurant.repository.KitchenRepository;
import org.springframework.stereotype.Service;

@Service
public class KitchenServiceImpl implements KitchenService {
    private final KitchenRepository kitchenRepository;

    public KitchenServiceImpl(KitchenRepository kitchenRepository) {
        this.kitchenRepository = kitchenRepository;
    }

    @Override
    public KitchenModel create(String name) {
        checkIfExists(name);

        return kitchenRepository.save(new KitchenModel(name));
    }
    private void checkIfExists(String name) {
        kitchenRepository.findAll()
                         .forEach(kitchen -> {
                             if (kitchen.getName()
                                        .equals(name)) {
                                 throw new KitchenAlreadyExistsException();
                             }
                         });
    }

    @Override
    public long count() {
        return kitchenRepository.count();
    }

    @Override
    public KitchenModel getById(long id) throws KitchenNotFoundException {
        return kitchenRepository.findById(id)
                                .orElseThrow(KitchenNotFoundException::new);
    }

    public static class KitchenNotFoundException extends RuntimeException {

    }
    public static class KitchenAlreadyExistsException extends RuntimeException {
    }
}
