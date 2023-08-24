package day1.day1demo2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//Kommer fra Lombok dependency
@Getter
@Setter
@NoArgsConstructor

//Kommer fra JPA dependency
@Entity
@Table(name = "spiller")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "player_name", length = 100, nullable = false)
    private String name;
    String country;
    String position;
    public  Player(String name, String country, String position) {
        this.name = name;
        this.country = country;
        this.position = position;
    }
}
