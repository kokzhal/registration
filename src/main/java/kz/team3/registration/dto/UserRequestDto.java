package kz.team3.registration.dto;

import kz.team3.registration.entity.UserGender;
import kz.team3.registration.entity.UserRole;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserRequestDto {
    @NotEmpty
    private String password;
    @NotEmpty
    private String studentId;
    @NotEmpty
    private String firstname;
    @NotEmpty
    private String lastname;
    @NotEmpty
    private String email;
    @NotEmpty
    private String program;
    @NotNull
    private Integer course;
    @NotEmpty
    private String phone;
    private UserRole userRole;
}
