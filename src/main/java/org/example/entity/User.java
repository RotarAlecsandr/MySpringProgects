package org.example.entity;

import lombok.*;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SelectBeforeUpdate
@ToString(of = {"firstName", "lastName", "age"})
@Table(name = "users")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userAddress_id", nullable = false)
    private UserAddress userAddress;

    public User(String firstName, String lastName, int age, UserAddress userAddress){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.userAddress = userAddress;
    }
}
