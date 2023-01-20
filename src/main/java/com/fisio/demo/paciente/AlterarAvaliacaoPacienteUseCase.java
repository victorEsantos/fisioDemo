package com.fisio.demo.paciente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

public interface AlterarAvaliacaoPacienteUseCase {

    void execute(UUID id, UUID avaliacaoId, AlterarAvaliacaoPacienteCommand command);


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class AlterarAvaliacaoPacienteCommand {
        private String queixa;
        private String tratamento;
        private String avaliacao;
        //getters and setters
    }
}