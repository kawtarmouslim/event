package org.example.helloevents.repository;

import org.example.helloevents.entites.Resrvation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResrvationRepository extends JpaRepository<Resrvation, Long> {
    @Query(value = "SELECT COUNT(idResrvation)  as nombreResrvation FROM Resrvation WHERE idClient=?", nativeQuery = true)
    Integer findByClientId(Long clientId);
}
