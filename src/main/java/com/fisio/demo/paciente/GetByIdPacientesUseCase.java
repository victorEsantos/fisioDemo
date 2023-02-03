package com.fisio.demo.paciente;

import com.fisio.demo.paciente.api.dto.PacienteDTO;

import java.util.UUID;

public interface GetByIdPacientesUseCase {

    PacienteDTO handle(UUID id);

}
