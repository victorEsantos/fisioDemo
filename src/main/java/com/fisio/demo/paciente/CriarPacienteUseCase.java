package com.fisio.demo.paciente;

import com.fisio.demo.paciente.api.dto.PacienteDTO;
import com.fisio.demo.paciente.domain.Sexo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

import static com.fisio.demo.paciente.PacienteUseCase.*;

public interface CriarPacienteUseCase {

        UUID execute(CriarPacienteCommand command);

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        class CriarPacienteCommand {
            private String nome;
            private LocalDate nascimento;
            private Sexo sexo;
            private String cpf;
            private String rg;
            private String estadoCivil;
            private String profissao;
            private String email;
            private String telefoneFixo;
            private String celular;
            private ConvenioCommand convenio;
            private EnderecoCommand endereco;


            public static CriarPacienteCommand from(PacienteDTO dto) {
                return CriarPacienteCommand.builder()
                        .nome(dto.getNome())
                        .nascimento(dto.getNascimento())
                        .sexo(dto.getSexo())
                        .cpf(dto.getCpf())
                        .rg(dto.getRg())
                        .estadoCivil(dto.getEstadoCivil())
                        .profissao(dto.getProfissao())
                        .email(dto.getEmail())
                        .telefoneFixo(dto.getTelefoneFixo())
                        .celular(dto.getCelular())
                        .convenio(ConvenioCommand.from(dto.getConvenio()))
                        .endereco(EnderecoCommand.from(dto.getEndereco()))
                        .build();
            }


        }
    }