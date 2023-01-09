package com.fisio.demo.paciente.domain.avaliacao;

import com.fisio.demo.paciente.domain.Paciente;
import com.fisio.demo.paciente.domain.evolucao.Evolucao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Avaliacao {
    @Id
    private UUID id;
    private String queixa;
    private String tratamento;
    private String avaliacao;

    private int Sequencia;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @OneToMany(mappedBy = "avaliacao")
    private Set<Evolucao> evolucoes;
}
