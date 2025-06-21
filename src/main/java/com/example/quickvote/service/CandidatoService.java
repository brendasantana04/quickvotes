package com.example.quickvote.service;

import com.example.quickvote.controller.CreateCandidatoDto;
import com.example.quickvote.models.CandidatoModel;
import com.example.quickvote.repository.CandidatoRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class CandidatoService {

    private CandidatoRepository candidatoRepository;

    public CandidatoService(CandidatoRepository candidatoRepository) {
        this.candidatoRepository = candidatoRepository;
    }

    public void createCandidato(CreateCandidatoDto createCandidatoDto) {

        // DTO -> ENTITY
        var entity = new CandidatoModel(
                UUID.randomUUID(),
                createCandidatoDto.nome(),
                Instant.now(),
                null);

        candidatoRepository.save(entity);
    }

}
