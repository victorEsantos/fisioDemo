package com.fisio.demo.paciente.service;

import com.fisio.demo.paciente.AlterarAvaliacaoPacienteUseCase;
import com.fisio.demo.paciente.domain.Paciente;
import com.fisio.demo.paciente.domain.PacienteDomainRepository;
import com.fisio.demo.paciente.domain.avaliacao.Avaliacao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AlterarAvaliacaoPacienteService implements AlterarAvaliacaoPacienteUseCase {

    private final PacienteDomainRepository pacienteRepository;

    @Override
    public void execute(UUID id, UUID avaliacaoId, AlterarAvaliacaoPacienteCommand command) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        paciente.getAvaliacoes().stream().filter(avaliacao -> avaliacao.getId().equals(avaliacaoId)).peek(avaliacao -> {
            avaliacao.setQueixa(command.getQueixa());
            avaliacao.setTratamento(command.getTratamento());
            avaliacao.setAvaliacao(command.getAvaliacao());
        }).findFirst().orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));

        pacienteRepository.save(paciente);

    }
}