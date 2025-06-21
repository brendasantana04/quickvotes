package com.example.quickvote.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Table(name = "TB_VOTO")
@Entity
public class VotoModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "id_candidato", referencedColumnName = "id")
    private CandidatoModel candidato;

    @OneToOne
    @JoinColumn(name = "id_eleitor", referencedColumnName = "id")
    private EleitorModel eleitor;

}
