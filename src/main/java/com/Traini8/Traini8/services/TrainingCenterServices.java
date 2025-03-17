package com.Traini8.Traini8.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Traini8.Traini8.entities.TrainingCenter;
import com.Traini8.Traini8.repositories.TrainingCenterRepository;

@Service
public class TrainingCenterServices {

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    public TrainingCenterServices(TrainingCenterRepository trainingCenterRepository) {
        this.trainingCenterRepository = trainingCenterRepository;
    }

    public TrainingCenter add(TrainingCenter trainingCenter) { 
        return trainingCenterRepository.save(trainingCenter);
    }

    

    public List<TrainingCenter> getTrainingCenterByFilters(String state, String city){
        return trainingCenterRepository.findByFilters(state , city);
    }

    
}
