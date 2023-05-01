package kz.team3.registration.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Bed {

    @Id
    private String id;
    private int bedNumber;
    private String roomId;
    private double price;
    private String currency;
    private String status;
    private int floor;
    private String block;

}
