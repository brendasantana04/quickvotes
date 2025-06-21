package com.example.quickvote.service;

import com.example.quickvote.repository.VotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotoService {
    List<VotoRepository.Resultado> contarVotosPorCandidato();
}

