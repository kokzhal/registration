package kz.team3.registration.service;

import kz.team3.registration.ResourceNotFoundException;
import kz.team3.registration.entity.Bed;
import kz.team3.registration.repository.BedRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedService {
    private final BedRepository bedRepository;
    private int bedCost = 300000;

    public BedService(BedRepository bedRepository) {
        this.bedRepository = bedRepository;
    }

    public List<Bed> getBeds() {
        return bedRepository.findAll();
    }

    public Bed updateBedStatus(Long bedId, String status) {
        Bed bed = bedRepository.findById(bedId)
                .orElseThrow(() -> new RuntimeException("Bed not found"));
        bed.setStatus(status);
        return bedRepository.save(bed);
    }

    public Bed getAvailableBed() {
        return bedRepository.findAvailableBed();
    }
    public List<Bed> getAllBeds() {
        return bedRepository.findAll();
    }

    public Bed getBedById(Long bedId) {
        return bedRepository.findById(bedId)
                .orElseThrow(() -> new ResourceNotFoundException("Bed not found with id: " + bedId));
    }

    public int getBedCost() {
        return bedCost;
    }

    public void setBedCost(int cost) {
        bedCost = cost;
    }
}
