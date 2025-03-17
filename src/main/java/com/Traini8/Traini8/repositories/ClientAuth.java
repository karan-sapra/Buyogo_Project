package com.Traini8.Traini8.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Traini8.Traini8.entities.ClientEntity;

@Repository
public interface ClientAuth extends JpaRepository<ClientEntity,Integer> {
 
    Optional<ClientEntity> findByClientIdAndClientToken(String clientId, String ClientToken);
}
