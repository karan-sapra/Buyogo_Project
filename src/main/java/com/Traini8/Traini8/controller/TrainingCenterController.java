package com.Traini8.Traini8.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Traini8.Traini8.entities.ClientEntity;
import com.Traini8.Traini8.entities.TrainingCenter;
import com.Traini8.Traini8.repositories.ClientAuth;
import com.Traini8.Traini8.services.TrainingCenterServices;

import jakarta.validation.Valid;

@RestController
public class TrainingCenterController {
    @Autowired
    private TrainingCenterServices trainingCenterServices;
    @Autowired
    private ClientAuth clientAuth;

    public TrainingCenterController(TrainingCenterServices trainingCenterServices, ClientAuth clientAuth) {
        this.trainingCenterServices = trainingCenterServices;
        this.clientAuth = clientAuth;
    }

    @PostMapping("/trainingcenter/add")
    public ResponseEntity<?> addTrainingCentxer( @Valid @RequestBody TrainingCenter trainingCenter
                                                              ,@RequestHeader(value = "Client-Id",required = false) String clientId
                                                              ,@RequestHeader(value = "Client-Token",required = false) String clientToken){

        if(clientId==null || clientToken==null){
            return ResponseEntity.status(401).body("Missing client credentials");
        }
    Optional<ClientEntity> clientEntity=clientAuth.findByClientIdAndClientToken(clientId, clientToken);
     if(clientEntity.isEmpty()){
         return ResponseEntity.status(401).body("Invalid client credentials");
     }
        TrainingCenter savedTrainingCenter=trainingCenterServices.add(trainingCenter);
        savedTrainingCenter.setInserted(true); 
      
            return ResponseEntity.status(201).body(savedTrainingCenter);
    }

    @GetMapping("/trainingcenter/get")
    public ResponseEntity<?> getTrainingCenter(
        @RequestParam(required = false) String state, 
        @RequestParam(required = false) String city,
        @RequestHeader(value = "Client-Id",required = false) String clientId
        ,@RequestHeader(value = "Client-Token",required = false) String clientToken)
        {
            if (clientId == null || clientToken == null) {
                return ResponseEntity.status(401).body("Missing client credentials");
                
            }
            Optional<ClientEntity> clientEntity = clientAuth.findByClientIdAndClientToken(clientId, clientToken);
            if (clientEntity.isEmpty()) {
                return ResponseEntity.status(401).body("Invalid client credentials");
            }
          List<TrainingCenter> getTrainingCenter = trainingCenterServices.getTrainingCenterByFilters(city,state);
        return ResponseEntity.ok(getTrainingCenter);
    }


}
