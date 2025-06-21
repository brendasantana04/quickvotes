package com.example.quickvote.controller;

import com.example.quickvote.models.CandidatoModel;
import com.example.quickvote.service.CandidatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")

public class CandidatoController {

    private CandidatoService candidatoService;

    public CandidatoController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService;
    }

    @PostMapping
    public ResponseEntity<CandidatoModel> createUser(@RequestBody CreateCandidatoDto createCandidatoDto) {
        candidatoService.createCandidato(createCandidatoDto);
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidatoModel> getCandidatoModelById(@PathVariable("id") String id) {
        return null;
    }

}
