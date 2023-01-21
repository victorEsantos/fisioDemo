package com.fisio.demo.paciente.domain.evolucao;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface EvolucaoPacienteDomainRepository {

    Optional<Set<Evolucao>> findByAvaliacaoId(UUID avaliacaoId);
}
