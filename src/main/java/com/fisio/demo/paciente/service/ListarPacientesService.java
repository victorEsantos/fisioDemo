package com.fisio.demo.paciente.service;

import com.fisio.demo.paciente.ListarPacientesUseCase;
import com.fisio.demo.paciente.api.dto.PacienteDTO;
import com.fisio.demo.paciente.domain.PacienteDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListarPacientesService implements ListarPacientesUseCase {

    private final PacienteDomainRepository repository;

    @Override
    public Page<PacienteDTO> handle() {
        var pacientes = repository.findAll();

        return new PageImpl<>(pacientes.stream().map(PacienteDTO::from).toList());
    }
}
