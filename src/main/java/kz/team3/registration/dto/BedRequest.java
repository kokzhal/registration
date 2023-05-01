package kz.team3.registration.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class BedRequest {
    @NotNull
    private int bedNumber;
    @NotEmpty
    private String roomId;
    @NotEmpty
    private String currency;
    @NotEmpty
    private String status;
    @NotNull
    private int floor;
    @NotEmpty
    private String block;

}
