package com.ecommerce.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @NotBlank
    @Size(min = 2, message = "Street name must be of 2 characters")
    private String street;

    @NotBlank
    @Size(min = 2, message = "Building name must be of 2 characters")
    private String buildingName;

    @NotBlank
    @Size(min = 2, message = "City name must be of 2 characters")
    private String city;

    @NotBlank
    @Size(min = 2, message = "State name must be of 2 characters")
    private String state;

    @NotBlank
    @Size(min = 2, message = "Country name must be of 2 characters")
    private String country;

//    @NotBlank
//    @Size(min = 6, message = "Pin Code name must be of 6 characters")
    private Integer  pinCode;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Address(String street, List<User> users, String country, String state, String city, String buildingName, Integer pinCode) {
        this.street = street;
        this.user = user;
        this.country = country;
        this.state = state;
        this.city = city;
        this.buildingName = buildingName;
        this.pinCode = pinCode;
    }
}
