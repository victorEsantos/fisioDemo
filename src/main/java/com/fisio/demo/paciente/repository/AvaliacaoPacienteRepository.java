package com.fisio.demo.paciente.repository;

import com.fisio.demo.paciente.domain.avaliacao.Avaliacao;
import com.fisio.demo.paciente.domain.avaliacao.AvaliacaoPacienteDomainRepository;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface AvaliacaoPacienteRepository extends AvaliacaoPacienteDomainRepository, Repository<Avaliacao, UUID> {
}
