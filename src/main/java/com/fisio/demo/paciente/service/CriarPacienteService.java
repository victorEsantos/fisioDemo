package com.fisio.demo.paciente.service;

import com.fisio.demo.paciente.CriarPacienteUseCase;
import com.fisio.demo.paciente.domain.Paciente;
import com.fisio.demo.paciente.domain.PacienteDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CriarPacienteService implements CriarPacienteUseCase {

    private final PacienteDomainRepository repository;

    @Override
    public UUID handle(CriarPacienteCommand cmd) {
        var paciente = Paciente.from(cmd);
        repository.save(paciente);

        return paciente.getId();
    }
}
