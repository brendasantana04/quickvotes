package com.example.quickvote.repository;

import com.example.quickvote.models.CandidatoModel;
import com.example.quickvote.models.VotoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends JpaRepository<VotoModel, Integer> {
    long countByCandidato(CandidatoModel candidato);

    @Procedure(procedureName = "ContarVotosPorCandidato")
    int contarVotosPorCandidato(@Param("candidato_id") int candidatoId);
}
