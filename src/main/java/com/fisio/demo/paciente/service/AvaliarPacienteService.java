package com.fisio.demo.paciente.service;

import com.fisio.demo.paciente.AvaliarPacienteUseCase;
import com.fisio.demo.paciente.domain.Paciente;
import com.fisio.demo.paciente.domain.PacienteDomainRepository;
import com.fisio.demo.paciente.domain.avaliacao.Avaliacao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AvaliarPacienteService implements AvaliarPacienteUseCase {

    private final PacienteDomainRepository pacienteRepository;

    @Override
    public void execute(UUID pacienteId, AvaliarPacienteCommand command) {
        Paciente paciente = pacienteRepository.findById(pacienteId).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setQueixa(command.getQueixa());
        avaliacao.setTratamento(command.getTratamento());
        avaliacao.setAvaliacao(command.getAvaliacao());
        avaliacao.setPaciente(paciente);

        paciente.getAvaliacoes().add(avaliacao);

        pacienteRepository.save(paciente);

    }
}