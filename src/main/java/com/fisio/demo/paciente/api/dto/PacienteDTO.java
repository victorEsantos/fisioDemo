package com.fisio.demo.paciente.api.dto;

import com.fisio.demo.endereco.domain.Endereco;
import com.fisio.demo.paciente.domain.Paciente;
import com.fisio.demo.paciente.domain.Sexo;
import com.fisio.demo.paciente.domain.convenio.Convenio;
import com.fisio.demo.paciente.domain.convenio.enums.ConvenioEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

import static java.util.Objects.isNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {
    private UUID id;
    private String nome;
    private LocalDate nascimento;
    private Sexo sexo;
    private String cpf;
    private String rg;
    private String estadoCivil;
    private String profissao;
    private String email;
    private String telefoneFixo;
    private String celular;
    private ConvenioDto convenio;
    private EnderecoDto endereco;

    public static PacienteDTO from(Paciente paciente){

        return new PacienteDTO(
                paciente.getId(),
                paciente.getNome(),
                paciente.getNascimento(),
                paciente.getSexo(),
                paciente.getCpf(),
                paciente.getRg(),
                paciente.getEstadoCivil(),
                paciente.getProfissao(),
                paciente.getEmail(),
                paciente.getTelefoneFixo(),
                paciente.getCelular(),
                ConvenioDto.from(paciente.getConvenio()),
                EnderecoDto.from(paciente.getEndereco())
        );

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ConvenioDto {
        private String nome;
        private String numero;
        private LocalDate validade;
        private ConvenioEnum convenio;
        private String numeroCns;

        public static ConvenioDto from(Convenio convenio) {
            if(isNull(convenio)) return null;

            return new ConvenioDto(
                    convenio.getNome(),
                    convenio.getNumero(),
                    convenio.getValidade(),
                    convenio.getConvenioMedico(),
                    convenio.getNumeroCns()
            );
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EnderecoDto {
        private String cep;
        private String estado;
        private String cidade;
        private String endereco;
        private String numero;
        private String bairro;
        private String complemento;

        public static EnderecoDto from(Endereco endereco) {

            if(isNull(endereco)) return null;

            return new EnderecoDto(
                    endereco.getCep(),
                    endereco.getEstado(),
                    endereco.getCidade(),
                    endereco.getEndereco(),
                    endereco.getNumero(),
                    endereco.getBairro(),
                    endereco.getComplemento()
            );
        }
    }
}
