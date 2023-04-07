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
    @SequenceGenerator(
            name = "bed_sequence",
            sequenceName = "bed_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bed_sequence"
    )
    private String id;
    private int bedNumber;
    private String roomId;
    private int price;
    private String currency;
    private String status;

}
