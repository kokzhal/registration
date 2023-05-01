package kz.team3.registration.service;

import kz.team3.registration.ResourceNotFoundException;
import kz.team3.registration.dto.BedRequest;
import kz.team3.registration.dto.UserRequestDto;
import kz.team3.registration.entity.Bed;
import kz.team3.registration.repository.BedRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Bed updateBedStatus(String bedId, String status) {
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

    public Bed getBedById(String bedId) {
        return bedRepository.findById(bedId)
                .orElseThrow(() -> new ResourceNotFoundException("Bed not found with id: " + bedId));
    }

    public int getBedCost() {
        return bedCost;
    }

    public void setBedCost(int cost) {
        bedCost = cost;
    }

    public Bed bedRequestToBed(BedRequest bedRequest, String bedId){


        // Generate ID for new bed

        Bed bed = new Bed();
        bed.setId(bedId);
        bed.setRoomId(bedRequest.getRoomId());
        bed.setCurrency(bedRequest.getCurrency());
        bed.setBedNumber(bedRequest.getBedNumber());
        bed.setBlock(bedRequest.getBlock());
        bed.setFloor(bedRequest.getFloor());
        bed.setStatus(bedRequest.getStatus());

        return bed;
    }

    private String generateBedId(BedRequest bedRequest) {
        return bedRequest.getBlock() + "-" + bedRequest.getRoomId() + "-" + bedRequest.getBedNumber();
    }

    public void createBed(BedRequest bedRequest){
        String bedId = generateBedId(bedRequest);
        if (bedRepository.existsById(bedId)) {
            throw new RuntimeException("Bed with ID " + bedId + " already exists");
        }


        Bed bed = bedRequestToBed(bedRequest, bedId);
        bedRepository.save(bed);
    }

    public void updateAllBedsPrice(double newPrice) {
        List<Bed> beds = bedRepository.findAll();
        for (Bed bed : beds) {
            bed.setPrice(newPrice);
            bedRepository.save(bed);
        }
    }



}
