package kz.team3.registration.controller;

import kz.team3.registration.dto.BedRequest;
import kz.team3.registration.entity.Bed;
import kz.team3.registration.entity.User;
import kz.team3.registration.service.BedService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/beds")
@RequiredArgsConstructor
public class BedController {

    private final BedService bedService;

    @GetMapping("/beds")
    public List<Bed> getBeds() {
        return bedService.getBeds();
    }

    @GetMapping("/available")
    public Bed getAvailableBed() {
        return bedService.getAvailableBed();
    }

    @PutMapping("/update/{bedId}")
    public Bed updateBedStatus(@PathVariable String bedId, @RequestBody String status){
        return bedService.updateBedStatus(bedId, status);
    }

    @GetMapping("/cost")
    public int getBedCost() {
        return bedService.getBedCost();
    }

    @GetMapping("/{bedId}")
    public Bed getBedById(@PathVariable String bedId) {
        return bedService.getBedById(bedId);
    }

    @PostMapping("/set/cost")
    public ResponseEntity<String> updateAllBedsPrice(@RequestBody double price) {
        bedService.updateAllBedsPrice(price);
        return ResponseEntity.ok().body("Beds' price updated successfully");
    }

    @PostMapping("/create")
    public void createBed(@RequestBody BedRequest bedRequest) {
        bedService.createBed(bedRequest);
    }


}
