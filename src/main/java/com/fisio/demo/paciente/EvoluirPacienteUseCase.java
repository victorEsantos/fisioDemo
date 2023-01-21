package com.fisio.demo.paciente;

import com.fisio.demo.paciente.domain.convenio.enums.ConvenioEnum;
import com.fisio.demo.paciente.domain.evolucao.Procedimento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

public interface EvoluirPacienteUseCase {
    void execute(UUID pacienteId, UUID avaliacaoId, EvoluirPacienteCommand command);

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class EvoluirPacienteCommand {
        private LocalDateTime atendimentoDe;
        private LocalDateTime atendimentoAte;
        private ConvenioEnum convenio;
        private String senhaAutenticador;
        private Procedimento procedimento;
        private String descricao;
    }
}