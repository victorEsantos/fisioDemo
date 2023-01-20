package com.fisio.demo.paciente;

import com.fisio.demo.paciente.api.dto.AvaliacaoDto;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface ListarAvaliacoesPacienteUseCase {

    Page<AvaliacaoDto> handle(UUID pacienteId);

}
