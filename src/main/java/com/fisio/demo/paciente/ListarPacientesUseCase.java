package com.fisio.demo.paciente;

import com.fisio.demo.paciente.api.dto.PacienteDTO;
import org.springframework.data.domain.Page;

public interface ListarPacientesUseCase {

    Page<PacienteDTO> handle();

}
