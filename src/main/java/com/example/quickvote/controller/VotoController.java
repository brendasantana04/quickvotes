package com.example.quickvote.controller;

import com.example.quickvote.models.CandidatoModel;
import com.example.quickvote.models.EleitorModel;
import com.example.quickvote.models.VotoModel;
import com.example.quickvote.repository.CandidatoRepository;
import com.example.quickvote.repository.EleitorRepository;
import com.example.quickvote.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class VotoController {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    private EleitorRepository eleitorRepository;

    @GetMapping("/resultado")
    public String mostrarResultado(Model model) {
        List<CandidatoModel> candidatos = (List<CandidatoModel>) candidatoRepository.findAll();

        Map<CandidatoModel, Long> votosPorCandidato = new HashMap<>();
        for (CandidatoModel candidato : candidatos) {
            long totalVotos = votoRepository.countByCandidato(candidato);
            votosPorCandidato.put(candidato, totalVotos);
        }

        model.addAttribute("votosPorCandidato", votosPorCandidato);
        return "resultado/resultado";
    }

    @GetMapping("/votar")
    public String mostrarTelaVotacao(CandidatoModel candidato, Model model) {
        List<CandidatoModel> candidatos = candidatoRepository.findAll();
        model.addAttribute("candidatos", candidatos);
        return "votacao/votacao";
    }

    @PostMapping("/votar")
    public String processarVoto(@RequestParam int eleitorId, @RequestParam int candidatoId, Model model) {
        EleitorModel eleitor = eleitorRepository.findById(eleitorId).orElse(null);
        CandidatoModel candidato = candidatoRepository.findById(candidatoId).orElse(null);

        if (eleitor == null || candidato == null) {
            return "redirect:/votar?erro";
        }

        VotoModel voto = new VotoModel();
        voto.setEleitor(eleitor);
        voto.setCandidato(candidato);
        votoRepository.save(voto);

        // chama a stored procedure
        int totalVotos = votoRepository.contarVotosPorCandidato(candidatoId);
        System.out.println("Total de votos para o candidato " + candidato.getNome() + ": " + totalVotos);

        // você pode adicionar esse total no model se quiser exibir em uma tela
        model.addAttribute("mensagem", "Voto registrado! Total atual para " + candidato.getNome() + ": " + totalVotos);

        return "redirect:/resultado";
    }

}
