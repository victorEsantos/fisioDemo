package com.fisio.demo.paciente.service;

import com.fisio.demo.paciente.EvoluirPacienteUseCase;
import com.fisio.demo.paciente.domain.Paciente;
import com.fisio.demo.paciente.domain.PacienteDomainRepository;
import com.fisio.demo.paciente.domain.avaliacao.Avaliacao;
import com.fisio.demo.paciente.domain.evolucao.Evolucao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EvoluirPacienteService implements EvoluirPacienteUseCase {

    private final PacienteDomainRepository pacienteRepository;

    @Override
    public void execute(UUID pacienteId, UUID avaliacaoId, EvoluirPacienteCommand command) {

        Paciente paciente = pacienteRepository.findById(pacienteId).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        Avaliacao avaliacao = paciente.getAvaliacoes().stream()
                .filter(avaliacao1 -> avaliacao1.getId().equals(avaliacaoId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));

        //avaliacao.evoluir(command);

        Evolucao evolucao = new Evolucao();
        evolucao.setAtendimentoDe(command.getAtendimentoDe());
        evolucao.setAtendimentoAte(command.getAtendimentoAte());
        evolucao.setConvenio(command.getConvenio());
        evolucao.setSenhaAutenticador(command.getSenhaAutenticador());
        evolucao.setProcedimento(command.getProcedimento());
        evolucao.setDescricao(command.getDescricao());
        evolucao.setAvaliacao(avaliacao);

        avaliacao.getEvolucoes().add(evolucao);

        pacienteRepository.save(paciente);

    }
}