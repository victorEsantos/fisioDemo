package com.fisio.demo.paciente.service;

import com.fisio.demo.paciente.GetByIdPacientesUseCase;
import com.fisio.demo.paciente.api.dto.PacienteDTO;
import com.fisio.demo.paciente.domain.PacienteDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetByIdPacientesService implements GetByIdPacientesUseCase {

    private final PacienteDomainRepository repository;

    @Override
    public PacienteDTO handle(UUID id) {
        return PacienteDTO.from(repository.findById(id).orElse(null));

    }
}
