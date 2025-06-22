package com.example.quickvote.repository;

import com.example.quickvote.models.CandidatoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends CrudRepository<CandidatoModel, Integer> {
}