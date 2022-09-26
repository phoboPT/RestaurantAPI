package com.example.restaurant.web;

import com.example.restaurant.model.Receptionist;
import com.example.restaurant.service.ReceptionistService;
import com.example.restaurant.service.ReceptionistServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
@RestController
@RequestMapping (value = "/receptionist", path = "/receptionist")
public class ReceptionistEndpoint {
    private final ReceptionistService receptionistService;

    public ReceptionistEndpoint(ReceptionistService receptionistService) {
        this.receptionistService = receptionistService;
    }

    @PostMapping ("/create")
    public Receptionist create(@RequestBody Receptionist receptionistModel) {
        return receptionistService.create(new Date(),
                                          receptionistModel.getAccount(),
                                          receptionistModel.getName(),
                                          receptionistModel.getPhone(),
                                          receptionistModel.getEmail());
    }

    @GetMapping ("/count")
    public long count() {
        return receptionistService.count();
    }

    @GetMapping ("/{id}")
    public Receptionist getById(@PathVariable long id) throws ReceptionistServiceImpl.ReceptionistNotFoundException {
        return receptionistService.getById(id);
    }

}
