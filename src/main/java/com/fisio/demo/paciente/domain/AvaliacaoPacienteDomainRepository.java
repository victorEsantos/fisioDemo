package com.fisio.demo.paciente.domain;

import com.fisio.demo.paciente.domain.avaliacao.Avaliacao;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface AvaliacaoPacienteDomainRepository {

    Optional<Set<Avaliacao>> findByPacienteId(UUID pacienteId);
}
