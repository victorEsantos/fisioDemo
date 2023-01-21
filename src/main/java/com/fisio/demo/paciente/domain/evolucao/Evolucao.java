package com.fisio.demo.paciente.domain.evolucao;

import com.fisio.demo.paciente.domain.Paciente;
import com.fisio.demo.paciente.domain.avaliacao.Avaliacao;
import com.fisio.demo.paciente.domain.convenio.enums.ConvenioEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Evolucao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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



    public Evolucao(UUID id, LocalDateTime atendimentoDe, LocalDateTime atendimentoAte, ConvenioEnum convenio, String senhaAutenticador, Procedimento procedimento, String descricao, int sequencia) {
        this.id = id;
        this.atendimentoDe = atendimentoDe;
        this.atendimentoAte = atendimentoAte;
        this.convenio = convenio;
        this.senhaAutenticador = senhaAutenticador;
        this.procedimento = procedimento;
        this.descricao = descricao;
        this.sequencia = sequencia;
    }


    public static Evolucao of(LocalDateTime atendimentoDe, LocalDateTime atendimentoAte, ConvenioEnum convenio, String senhaAutenticador, Procedimento procedimento, String descricao) {
        return new Evolucao(null, atendimentoDe, atendimentoAte, convenio, senhaAutenticador, procedimento, descricao, 1);
    }

}
