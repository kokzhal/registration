package kz.team3.registration.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Room {
    @Id
    private int id;
    private String roomName;
    private int floor;
    private String block;
    private int place;
    private boolean status;

}
