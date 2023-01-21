package com.fisio.demo.paciente;

import com.fisio.demo.paciente.api.dto.EvolucaoDto;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface ListarEvolucoesPacienteUseCase {

    Page<EvolucaoDto> handle(UUID pacienteId);

}
