package kz.team3.registration.Bed;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedService {
    public List<Bed> getBeds()

    {
        return List.of(
                new Bed(
                        "active",
                        "kzt",
                        1,
                        "190107034",
                        "IS4",
                        400000
                )
        );
    }
}
