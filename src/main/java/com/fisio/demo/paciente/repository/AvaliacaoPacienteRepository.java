package com.fisio.demo.paciente.repository;

import com.fisio.demo.paciente.domain.AvaliacaoPacienteDomainRepository;
import com.fisio.demo.paciente.domain.avaliacao.Avaliacao;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface AvaliacaoPacienteRepository extends AvaliacaoPacienteDomainRepository, Repository<Avaliacao, UUID> {
}
