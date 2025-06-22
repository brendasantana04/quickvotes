package com.example.quickvote.controller;

import com.example.quickvote.models.CandidatoModel;
import com.example.quickvote.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CandidatoController {

    @Autowired
    private CandidatoRepository candidatoRepository;

    //rota da tela inicial de cadastro de candidato
    @GetMapping("/cadastro-candidato")
    public String cadastroCandidato(CandidatoModel candidato) {
        return "candidato/cadastro-candidato";
    }

    //criacao de um novo candidato
    @PostMapping("adicionar-candidato")
    public String adicionarCandidato(@RequestBody CandidatoModel candidato) {
        candidatoRepository.save(candidato);
        return "redirect:/cadastro-candidato";
    }

    //deletar um candidato
    @GetMapping("/delete-candidato/{id}")
    public String deleteCandidato(@PathVariable("id") int id) {
        candidatoRepository.deleteById(id);
        return "redirect:/cadastro-candidato";
    }

    //editar um candidato
    @PostMapping("/editar-candidato/{id}")
    public String editarCandidato(@PathVariable("id") int id, @RequestBody CandidatoModel candidato) {
        candidato.setId(id);
        candidatoRepository.save(candidato);
        return "redirect:/cadastro-candidato";
    }
}