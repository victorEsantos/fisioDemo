package com.fisio.demo.paciente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

public interface AvaliarPacienteUseCase {
    void execute(UUID pacienteId, AvaliarPacienteCommand command);

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class AvaliarPacienteCommand {
        private String queixa;
        private String tratamento;
        private String avaliacao;
    }
}