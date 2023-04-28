package kz.team3.registration.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Payment {
    @Id
    private Integer id;
    private Date paymentDate;
    private String paymentType;
    private Double paymentAmount;
}
