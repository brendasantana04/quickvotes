package com.example.quickvote.controller;

import com.example.quickvote.models.EleitorModel;
import com.example.quickvote.repository.EleitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EleitorController {

    @Autowired
    private EleitorRepository eleitorRepository;

    //rota de tela para cadastro de eleitores
    @GetMapping("/cadastro-eleitor")
    public String cadastroEleitor(EleitorModel eleitor) {
        return "eleitor/cadastro-eleitor";
    }

    //criação de um novo eleitor
    @PostMapping("adicionar-eleitor")
    public String adicionarEleitor(@RequestBody EleitorModel eleitor) {
        eleitorRepository.save(eleitor);
        return "redirect:/cadastro-eleitor";
    }

    //deletar um eleitor
    @GetMapping("/delete-eleitor/{id}")
    public String deleteEleitor(@PathVariable("id") int id) {
        eleitorRepository.deleteById(id);
        return "redirect:/cadastro-eleitor";
    }

    //editar um eleitor
    @PostMapping("/editar-eleitor/{id}")
    public String editarEleitor(@PathVariable("id") int id, @ModelAttribute EleitorModel eleitor) {
        eleitor.setId(id);
        eleitorRepository.save(eleitor);
        return "redirect:/cadastro-eleitor";
    }
}