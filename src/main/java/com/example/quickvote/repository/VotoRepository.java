package com.example.quickvote.repository;

import com.example.quickvote.models.CandidatoModel;
import com.example.quickvote.models.VotoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends JpaRepository<VotoModel, Integer> {
    long countByCandidato(CandidatoModel candidato);
}
