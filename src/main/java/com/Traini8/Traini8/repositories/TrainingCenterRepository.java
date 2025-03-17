package com.Traini8.Traini8.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Traini8.Traini8.entities.TrainingCenter;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter,Integer> {

    @Query("SELECT t FROM TrainingCenter t WHERE " +
    "(:city IS NULL OR t.address.city LIKE %:city%) AND " +
    "(:state IS NULL OR t.address.state LIKE %:state%)")
List<TrainingCenter> findByFilters(@Param("city") String city, 
                                @Param("state") String state);

}