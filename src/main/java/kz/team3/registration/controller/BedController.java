package kz.team3.registration.controller;

import kz.team3.registration.entity.Bed;
import kz.team3.registration.entity.User;
import kz.team3.registration.service.BedService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/beds")
@RequiredArgsConstructor
public class BedController {

    private final BedService bedService;

    @GetMapping
    public List<Bed> getBeds() {
        return bedService.getBeds();
    }

    @GetMapping("available")
    public Bed getAvailableBed() {
        return bedService.getAvailableBed();
    }

    @PutMapping("update/{bedId}")
    public Bed updateBedStatus(@PathVariable Long bedId, @RequestBody String status){
        return bedService.updateBedStatus(bedId, status);
    }

    @GetMapping("/cost")
    public int getBedCost() {
        return bedService.getBedCost();
    }

    @GetMapping("/{bedId}")
    public Bed getBedById(@PathVariable Long bedId) {
        return bedService.getBedById(bedId);
    }

    @PostMapping("/set/cost")
    public void setBedCost(@RequestBody int cost) {
        bedService.setBedCost(cost);
    }


}
