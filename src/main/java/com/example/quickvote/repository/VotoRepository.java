package com.example.quickvote.repository;

import com.example.quickvote.models.VotoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VotoRepository extends JpaRepository<VotoModel, Long> {

    @Query("SELECT c.nome as nomeCandidato, COUNT(v.id_eleitor) as qtdeVotos " +
            "FROM tb_voto v " +
            "JOIN tb_candidato c ON v.id_candidato = c.id " +
            "GROUP BY c.nome")
    List<Resultado> countVotosByCandidato();

    public interface Resultado {
        String getNomeCandidato();
        Long getQtdeVotos();
    }
}