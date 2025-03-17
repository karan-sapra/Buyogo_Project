package com.Traini8.Traini8.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class Address {
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    
    private String detailedAddress;
    private String pincode;

}

