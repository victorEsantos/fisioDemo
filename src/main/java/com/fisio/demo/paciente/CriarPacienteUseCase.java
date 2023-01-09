package com.fisio.demo.paciente;

import com.fisio.demo.paciente.api.dto.PacienteDTO;
import lombok.*;

import java.util.UUID;

public interface CriarPacienteUseCase {

    UUID handle(CriarPacienteCommand cmd);

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class CriarPacienteCommand {
        String nome;
        String sobrenome;
        String cpf;
        String rg;
        String email;
        String profissao;
        String telefone;
        String celular;

        public static CriarPacienteCommand from(PacienteDTO dto) {
            return CriarPacienteCommand.builder()
                    .nome(dto.getNome())
                    .sobrenome(dto.getSobrenome())
                    .cpf(dto.getCpf())
                    .rg(dto.getRg())
                    .email(dto.getEmail())
                    .profissao(dto.getProfissao())
                    .telefone(dto.getTelefone())
                    .celular(dto.getCelular())
                    .build();
        }
    }
}
