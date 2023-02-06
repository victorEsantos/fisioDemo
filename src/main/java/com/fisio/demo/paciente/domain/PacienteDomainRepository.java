package com.fisio.demo.paciente.domain;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface PacienteDomainRepository {
    void save(Paciente paciente);

    Set<Paciente> findAll();

    Optional<Paciente> findById(UUID id);

    void deleteById(UUID id);
}
