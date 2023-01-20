package com.fisio.demo.paciente.domain.evolucao;

import com.fisio.demo.paciente.domain.avaliacao.Avaliacao;
import com.fisio.demo.paciente.domain.convenio.enums.ConvenioEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Evolucao {
    @Id
    private UUID id;

    private LocalDateTime atendimentoDe;
    private LocalDateTime atendimentoAte;
    private ConvenioEnum convenio;
    private String senhaAutenticador;
    private Procedimento procedimento;
    private String descricao;
    private int sequencia;

    @ManyToOne
    @JoinColumn(name = "avaliacao_id", nullable = false)
    private Avaliacao avaliacao;

}
