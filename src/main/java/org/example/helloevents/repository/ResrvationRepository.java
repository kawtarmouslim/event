package org.example.helloevents.repository;

import org.example.helloevents.entites.Resrvation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResrvationRepository extends JpaRepository<Resrvation, Long> {
}
