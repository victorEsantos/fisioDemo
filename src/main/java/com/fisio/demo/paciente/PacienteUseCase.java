package com.fisio.demo.paciente;

import com.fisio.demo.paciente.api.dto.PacienteDTO;
import com.fisio.demo.paciente.domain.convenio.enums.ConvenioEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import static java.util.Objects.isNull;

@Data
public class PacienteUseCase {


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ConvenioCommand {
        private String nome;
        private String numero;
        private LocalDate validade;
        private ConvenioEnum convenio;
        private String numeroCns;

        public static ConvenioCommand from(PacienteDTO.ConvenioDto convenio) {
            if(isNull(convenio)) return null;

            return ConvenioCommand.builder()
                    .nome(convenio.getNome())
                    .numero(convenio.getNumero())
                    .validade(convenio.getValidade())
                    .convenio(convenio.getConvenio())
                    .numeroCns(convenio.getNumeroCns())
                    .build();
        }
    }


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class EnderecoCommand {
        private String cep;
        private String estado;
        private String cidade;
        private String endereco;
        private String numero;
        private String bairro;
        private String complemento;

        public static EnderecoCommand from(PacienteDTO.EnderecoDto endereco) {
            if(isNull(endereco)) return null;

            return EnderecoCommand.builder()
                    .cep(endereco.getCep())
                    .estado(endereco.getEstado())
                    .cidade(endereco.getCidade())
                    .endereco(endereco.getEndereco())
                    .numero(endereco.getNumero())
                    .bairro(endereco.getBairro())
                    .complemento(endereco.getComplemento())
                    .build();
        }
    }

}
