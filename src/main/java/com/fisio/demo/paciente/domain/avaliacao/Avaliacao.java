package com.fisio.demo.paciente.domain.avaliacao;

import com.fisio.demo.paciente.domain.Paciente;
import com.fisio.demo.paciente.domain.evolucao.Evolucao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
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
    private String avaliacao;

    @CreationTimestamp
    private LocalDate criadoEm;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @OneToMany(mappedBy = "avaliacao")
    private Set<Evolucao> evolucoes = new HashSet<>();
}
