package com.example.quickvote.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_VOTO")
@Entity
public class VotoModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "id_candidato", referencedColumnName = "id")
    private CandidatoModel candidato;

    @OneToOne
    @JoinColumn(name = "id_eleitor", referencedColumnName = "id")
    private EleitorModel eleitor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CandidatoModel getCandidato() {
        return candidato;
    }

    public void setCandidato(CandidatoModel candidato) {
        this.candidato = candidato;
    }

    public EleitorModel getEleitor() {
        return eleitor;
    }

    public void setEleitor(EleitorModel eleitor) {
        this.eleitor = eleitor;
    }
}
