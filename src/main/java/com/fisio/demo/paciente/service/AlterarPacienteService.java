package com.fisio.demo.paciente.service;

import com.fisio.demo.paciente.AlterarPacienteUseCase;
import com.fisio.demo.paciente.domain.Paciente;
import com.fisio.demo.paciente.domain.PacienteDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlterarPacienteService implements AlterarPacienteUseCase {
    private final PacienteDomainRepository repository;


    @Override
    public void execute(AlterarPacienteUseCase.AlterarPacienteCommand command) {
        Paciente paciente = repository.findById(command.getId()).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        paciente.alterar(command);

        repository.save(paciente);

    }
}
