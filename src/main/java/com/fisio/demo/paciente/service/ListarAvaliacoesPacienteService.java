package com.fisio.demo.paciente.service;

import com.fisio.demo.paciente.ListarAvaliacoesPacienteUseCase;
import com.fisio.demo.paciente.api.dto.AvaliacaoDto;
import com.fisio.demo.paciente.domain.avaliacao.AvaliacaoPacienteDomainRepository;
import com.fisio.demo.paciente.domain.avaliacao.Avaliacao;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ListarAvaliacoesPacienteService implements ListarAvaliacoesPacienteUseCase {
    private final AvaliacaoPacienteDomainRepository avaliacaoPacienteDomainRepository;

    @Override
    public Page<AvaliacaoDto> handle(UUID pacienteId) {
        Set<Avaliacao> avaliacoes = avaliacaoPacienteDomainRepository.findByPacienteId(pacienteId).orElse(Set.of());

        return new PageImpl<>(avaliacoes.stream().map(AvaliacaoDto::from).toList());
    }
}
