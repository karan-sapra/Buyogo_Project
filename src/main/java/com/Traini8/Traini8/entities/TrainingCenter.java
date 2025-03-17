package com.Traini8.Traini8.entities;

import jakarta.persistence.Transient;
import java.time.Instant;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingCenter {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(nullable = false)
@Size(max=40)
private String centerName;

@Column(nullable = false,unique = true)
@Size(min = 12,max=12,message = "Center code must be of 12 characters")
private String centerCode;

@Embedded
private Address address;

private int studentCapacity;


@ElementCollection
private List<String> coursesOffered;

@Email(message = "Email should be valid")
@Column(nullable = false,unique = true)
private String contactEmail;

@Pattern(regexp = "[0-9]{10}",message = "phone number must be of 10 digits")
@Column(nullable = false)
private String contactPhone;

@CreationTimestamp
@Column(nullable = false,updatable = false)
private Instant createdOn;

@Transient
@JsonIgnore
private Boolean inserted;



}