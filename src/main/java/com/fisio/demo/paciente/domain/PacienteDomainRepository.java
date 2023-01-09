package com.fisio.demo.paciente.domain;

import java.util.Set;

public interface PacienteDomainRepository {
    void save(Paciente paciente);

    Set<Paciente> findAll();
}
