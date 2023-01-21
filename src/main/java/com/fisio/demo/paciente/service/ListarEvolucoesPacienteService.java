package com.fisio.demo.paciente.service;

import com.fisio.demo.paciente.ListarEvolucoesPacienteUseCase;
import com.fisio.demo.paciente.api.dto.EvolucaoDto;
import com.fisio.demo.paciente.domain.avaliacao.Avaliacao;
import com.fisio.demo.paciente.domain.evolucao.Evolucao;
import com.fisio.demo.paciente.domain.evolucao.EvolucaoPacienteDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ListarEvolucoesPacienteService implements ListarEvolucoesPacienteUseCase {
    private final EvolucaoPacienteDomainRepository avaliacaoPacienteDomainRepository;

    @Override
    public Page<EvolucaoDto> handle(UUID avaliacaoId) {
        Set<Evolucao> evolucaos = avaliacaoPacienteDomainRepository.findByAvaliacaoId(avaliacaoId).orElse(Set.of());

        return new PageImpl<>(evolucaos.stream().map(EvolucaoDto::from).toList());
    }
}
