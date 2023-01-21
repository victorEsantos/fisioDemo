package com.fisio.demo.paciente.repository;

import com.fisio.demo.paciente.domain.evolucao.Evolucao;
import com.fisio.demo.paciente.domain.evolucao.EvolucaoPacienteDomainRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface EvolucaoPacienteRepository extends EvolucaoPacienteDomainRepository, Repository<Evolucao, UUID> {


    Optional<Set<Evolucao>> findByAvaliacaoId(UUID avaliacaoId);

}
