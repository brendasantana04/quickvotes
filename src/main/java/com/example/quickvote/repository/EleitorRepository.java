package com.example.quickvote.repository;

import com.example.quickvote.models.EleitorModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EleitorRepository extends CrudRepository<EleitorModel, Integer> {
}
