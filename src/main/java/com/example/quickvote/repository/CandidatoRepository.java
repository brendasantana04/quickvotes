package com.example.quickvote.repository;

import com.example.quickvote.models.CandidatoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CandidatoRepository extends JpaRepository<CandidatoModel, UUID> {
}