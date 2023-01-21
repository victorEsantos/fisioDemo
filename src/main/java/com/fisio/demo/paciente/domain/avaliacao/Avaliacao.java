package com.fisio.demo.paciente.domain.avaliacao;

import com.fisio.demo.paciente.EvoluirPacienteUseCase;
import com.fisio.demo.paciente.domain.Paciente;
import com.fisio.demo.paciente.domain.evolucao.Evolucao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String queixa;
    private String tratamento;
    private String descricao;

    @CreationTimestamp
    private LocalDate criadoEm;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @OneToMany(mappedBy = "avaliacao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Evolucao> evolucoes = new HashSet<>();

    public void evoluir(EvoluirPacienteUseCase.EvoluirPacienteCommand command) {
        this.getEvolucoes().add(Evolucao.of(command.getAtendimentoDe(), command.getAtendimentoAte(), command.getConvenio(), command.getSenhaAutenticador(), command.getProcedimento(), command.getDescricao()));
    }
}
