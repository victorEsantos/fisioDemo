package com.fisio.demo.paciente.domain.convenio;

import com.fisio.demo.paciente.PacienteUseCase;
import com.fisio.demo.paciente.domain.Paciente;
import com.fisio.demo.paciente.domain.convenio.enums.ConvenioEnum;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Convenio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String numero;
    private LocalDate validade;
    private ConvenioEnum convenio;
    @OneToOne(mappedBy = "convenio")
    private Paciente paciente;

    public static Convenio from(PacienteUseCase.ConvenioCommand convenio) {
        return Convenio.builder()
                .nome(convenio.getNome())
                .numero(convenio.getNumero())
                .validade(convenio.getValidade())
                .convenio(convenio.getConvenio())
                .build();
    }
}