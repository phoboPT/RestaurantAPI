package com.example.restaurant.service.modelService;

import com.example.restaurant.model.AccountModel;
import com.example.restaurant.model.ReceptionistModel;
import com.example.restaurant.repository.ReceptionistRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class ReceptionistServiceImpl implements ReceptionistService {
    private final ReceptionistRepository receptionistRepository;

    public ReceptionistServiceImpl(ReceptionistRepository receptionistRepository) {
        this.receptionistRepository = receptionistRepository;
    }

    @Override
    public ReceptionistModel create(Date dateJoined, AccountModel accountModel, String name, String phoneNumber,
                                    String email) {
        return receptionistRepository.save(new ReceptionistModel(dateJoined, accountModel, name, phoneNumber, email));
    }

    @Override
    public long count() {
        return receptionistRepository.count();

    }

    @Override
    public ReceptionistModel getById(long id) throws ReceptionistNotFoundException {
        return receptionistRepository.findById(id)
                                     .orElseThrow(ReceptionistNotFoundException::new);
    }

    public static class ReceptionistNotFoundException extends RuntimeException {

    }
}
