package kz.team3.registration.controller;

import kz.team3.registration.entity.Bed;
import kz.team3.registration.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/beds")
public class BedController {

    private final BedService bedService;

    @Autowired
    public BedController(BedService bedService) {
        this.bedService = bedService;
    }

    @GetMapping
    public List<Bed> getBeds() {
        return bedService.getBeds();
    }

}
