package org.example.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(of = {"city", "street", "house"})
@Table(name="userAddress")
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private int house;
    @OneToOne(mappedBy = "userAddress")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    public UserAddress(String city, String street, int house) {
        this.user = user;
        this.city = city;
        this.street = street;
        this.house = house;
    }
}
