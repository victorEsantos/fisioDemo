package com.fisio.demo.paciente.api;

import com.fisio.demo.paciente.AlterarAvaliacaoPacienteUseCase;
import com.fisio.demo.paciente.AlterarPacienteUseCase;
import com.fisio.demo.paciente.AvaliarPacienteUseCase;
import com.fisio.demo.paciente.CriarPacienteUseCase;
import com.fisio.demo.paciente.CriarPacienteUseCase.CriarPacienteCommand;
import com.fisio.demo.paciente.EvoluirPacienteUseCase;
import com.fisio.demo.paciente.GetByIdPacientesUseCase;
import com.fisio.demo.paciente.ListarAvaliacoesPacienteUseCase;
import com.fisio.demo.paciente.ListarEvolucoesPacienteUseCase;
import com.fisio.demo.paciente.ListarPacientesUseCase;
import com.fisio.demo.paciente.api.dto.AvaliacaoDto;
import com.fisio.demo.paciente.api.dto.EvolucaoDto;
import com.fisio.demo.paciente.api.dto.PacienteDTO;
import com.fisio.demo.paciente.domain.PacienteDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    private final GetByIdPacientesUseCase getByIdPacientesUseCase;
    private final AlterarPacienteUseCase alterarPacienteUseCase;
    private final AvaliarPacienteUseCase avaliarPacienteUseCase;
    private final AlterarAvaliacaoPacienteUseCase alterarAvaliacaoPacienteUseCase;
    private final ListarAvaliacoesPacienteUseCase listarAvaliacoesPacienteUseCase;
    private final EvoluirPacienteUseCase evoluirPacienteUseCase;
    private final ListarEvolucoesPacienteUseCase listarEvolucoesPacienteUseCase;
    private final PacienteDomainRepository pacienteDomainRepository;


    @PostMapping
    public ResponseEntity<String> create(@RequestBody PacienteDTO dto) {
        var id = criarPacienteUseCase.execute(CriarPacienteCommand.from(dto));

        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        pacienteDomainRepository.deleteById(id);
        //todo criar service

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<PacienteDTO>> getAll(){
        var pacientes = listarPacientesUseCase.handle();

        return ResponseEntity.of(Optional.of(pacientes));

    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> getById(@PathVariable UUID id){
        var pacientes = getByIdPacientesUseCase.handle(id);

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

    @GetMapping("/{id}/avaliacoes")
    public ResponseEntity<Page<AvaliacaoDto>> getAllAvaliacoes(@PathVariable("id") UUID id){
        var avaliacoes = listarAvaliacoesPacienteUseCase.handle(id);

        return ResponseEntity.of(Optional.of(avaliacoes));

    }

    @PostMapping("/{id}/avaliacoes/{avaliacaoId}/evoluir")
    public ResponseEntity<String> evoluir(@PathVariable("id") UUID id,
                                          @PathVariable("avaliacaoId") UUID avaliacaoId,
                                          @RequestBody EvoluirPacienteUseCase.EvoluirPacienteCommand command) {

        evoluirPacienteUseCase.execute(id, avaliacaoId, command);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/avaliacoes/{avaliacaoId}/evolucoes")
    public ResponseEntity<Page<EvolucaoDto>> getAllEvolucoes(@PathVariable("avaliacaoId") UUID avaliacaoId){
        var avaliacoes = listarEvolucoesPacienteUseCase.handle(avaliacaoId);

        return ResponseEntity.of(Optional.of(avaliacoes));

    }

}
