package com.fisio.demo.paciente.repository;

import com.fisio.demo.paciente.domain.Paciente;
import com.fisio.demo.paciente.domain.PacienteDomainRepository;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface PacienteRepository extends PacienteDomainRepository, Repository<Paciente, UUID> {
}
