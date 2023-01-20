package com.fisio.demo.paciente.api;

import com.fisio.demo.paciente.AlterarAvaliacaoPacienteUseCase;
import com.fisio.demo.paciente.AlterarPacienteUseCase;
import com.fisio.demo.paciente.AvaliarPacienteUseCase;
import com.fisio.demo.paciente.CriarPacienteUseCase;
import com.fisio.demo.paciente.CriarPacienteUseCase.CriarPacienteCommand;
import com.fisio.demo.paciente.ListarAvaliacoesPacienteUseCase;
import com.fisio.demo.paciente.ListarPacientesUseCase;
import com.fisio.demo.paciente.api.dto.AvaliacaoDto;
import com.fisio.demo.paciente.api.dto.PacienteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping(path = PacienteController.PATH)
@RequiredArgsConstructor
public class PacienteController {

    public static final String PATH = "/pacientes";

    private final CriarPacienteUseCase criarPacienteUseCase;
    private final ListarPacientesUseCase listarPacientesUseCase;
    private final AlterarPacienteUseCase alterarPacienteUseCase;
    private final AvaliarPacienteUseCase avaliarPacienteUseCase;
    private final AlterarAvaliacaoPacienteUseCase alterarAvaliacaoPacienteUseCase;
    private final ListarAvaliacoesPacienteUseCase listarAvaliacoesPacienteUseCase;


    @PostMapping
    public ResponseEntity<String> create(@RequestBody PacienteDTO dto) {
        var id = criarPacienteUseCase.execute(CriarPacienteCommand.from(dto));

        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<PacienteDTO>> getAll(){
        var pacientes = listarPacientesUseCase.handle();

        return ResponseEntity.of(Optional.of(pacientes));

    }

    @PutMapping("/{id}/alterar")
    public ResponseEntity<String> update(@PathVariable UUID id, @RequestBody PacienteDTO dto) {
        alterarPacienteUseCase.execute(AlterarPacienteUseCase.AlterarPacienteCommand.from(dto, id));

        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/avaliar")
    public ResponseEntity<String> createAvaliacao(@PathVariable("id") UUID id,
                                                  @RequestBody AvaliarPacienteUseCase.AvaliarPacienteCommand command) {
        avaliarPacienteUseCase.execute(id, command);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/avaliacoes/{avaliacaoId}/alterar")
    public ResponseEntity<String> updateAvaliacao(@PathVariable("id") UUID id,
                                                  @PathVariable("avaliacaoId") UUID avaliacaoId,
                                                  @RequestBody AlterarAvaliacaoPacienteUseCase.AlterarAvaliacaoPacienteCommand command) {
        alterarAvaliacaoPacienteUseCase.execute(id, avaliacaoId, command);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/avalicoes")
    public ResponseEntity<Page<AvaliacaoDto>> getAllAvaliacoes(@PathVariable("id") UUID id){
        var avaliacoes = listarAvaliacoesPacienteUseCase.handle(id);

        return ResponseEntity.of(Optional.of(avaliacoes));

    }

}
