package com.fisio.demo.paciente.domain;

import com.fisio.demo.paciente.CriarPacienteUseCase.CriarPacienteCommand;
import com.fisio.demo.paciente.domain.avaliacao.Avaliacao;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Paciente {
    @Id
    private UUID id;
    private String nome;
    public String sobrenome;
    private String cpf;
    private String email;
    private String rg;
    private String profissao;
    private String telefone;
    private String celular;

    @OneToMany(mappedBy = "paciente")
    private Set<Avaliacao> avaliacoes;


    public static Paciente from(CriarPacienteCommand cmd) {
        return Paciente
                .builder()
                .id(UUID.randomUUID())
                .nome(cmd.getNome())
                .sobrenome(cmd.getSobrenome())
                .cpf(cmd.getCpf())
                .rg(cmd.getRg())
                .email(cmd.getEmail())
                .profissao(cmd.getProfissao())
                .telefone(cmd.getTelefone())
                .celular(cmd.getCelular())
                .build();
    }
}
