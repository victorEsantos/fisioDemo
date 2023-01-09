package com.fisio.demo.paciente.api;

import com.fisio.demo.paciente.CriarPacienteUseCase;
import com.fisio.demo.paciente.CriarPacienteUseCase.CriarPacienteCommand;
import com.fisio.demo.paciente.ListarPacientesUseCase;
import com.fisio.demo.paciente.api.dto.PacienteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(path = PacienteController.PATH)
@RequiredArgsConstructor
public class PacienteController {

    public static final String PATH = "/pacientes";

    private final CriarPacienteUseCase criarPacienteUseCase;
    private final ListarPacientesUseCase listarPacientesUseCase;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody PacienteDTO dto) {
        var id = criarPacienteUseCase.handle(CriarPacienteCommand.from(dto));

        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<PacienteDTO>> getAll(){
        var pacientes = listarPacientesUseCase.handle();

        return ResponseEntity.of(Optional.of(pacientes));

    }
}
