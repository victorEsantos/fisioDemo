package com.fisio.demo.paciente.domain;

import com.fisio.demo.endereco.model.Endereco;
import com.fisio.demo.paciente.AlterarPacienteUseCase;
import com.fisio.demo.paciente.CriarPacienteUseCase;
import com.fisio.demo.paciente.domain.avaliacao.Avaliacao;
import com.fisio.demo.paciente.domain.convenio.Convenio;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;

import static com.fisio.demo.paciente.CriarPacienteUseCase.*;

@Entity
@Table(name = "paciente")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String nascimento;
    private String sexo;
    private String cpf;
    private String rg;
    private String estadoCivil;
    private String profissao;
    private String email;
    private String telefoneFixo;
    private String celular;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "convenio_id", referencedColumnName = "id")
    private Convenio convenio;
    private String numeroCNS;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Avaliacao> avaliacoes;


    public static Paciente from(CriarPacienteCommand cmd) {
        return Paciente
                .builder()
                .id(UUID.randomUUID())
                .nome(cmd.getNome())
                .cpf(cmd.getCpf())
                .rg(cmd.getRg())
                .email(cmd.getEmail())
                .profissao(cmd.getProfissao())
                .telefoneFixo(cmd.getTelefoneFixo())
                .celular(cmd.getCelular())
                .endereco(Endereco.from(cmd.getEndereco()))
                .convenio(Convenio.from(cmd.getConvenio()))
                .build();
    }

    public void alterar(AlterarPacienteUseCase.AlterarPacienteCommand command) {
        this.nome = command.getNome();
        this.nascimento = command.getNascimento();
        this.sexo = command.getSexo();
        this.cpf = command.getCpf();
        this.rg = command.getRg();
        this.estadoCivil = command.getEstadoCivil();
        this.profissao = command.getProfissao();
        this.email = command.getEmail();
        this.telefoneFixo = command.getTelefoneFixo();
        this.celular = command.getCelular();
        this.convenio = Convenio.from(command.getConvenio());
        this.numeroCNS = command.getNumeroCNS();
        this.endereco = Endereco.from(command.getEndereco());
    }
}
