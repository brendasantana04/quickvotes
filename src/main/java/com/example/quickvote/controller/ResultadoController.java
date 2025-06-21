package com.example.quickvote.controller;

import com.example.quickvote.repository.VotoRepository;
import com.example.quickvote.service.VotoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/resultado")
public class ResultadoController {

    private final VotoService votoService;

    public ResultadoController(VotoService votoService) {
        this.votoService = votoService;
    }

    @GetMapping
    public List<VotoRepository.Resultado> getResultadosVotacao() {
        return votoService.contarVotosPorCandidato();
    }
}
