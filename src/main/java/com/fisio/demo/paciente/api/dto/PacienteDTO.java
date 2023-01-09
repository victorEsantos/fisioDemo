package com.fisio.demo.paciente.api.dto;

import com.fisio.demo.paciente.domain.Paciente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private String rg;
    private String profissao;
    private String telefone;
    private String celular;

    public static PacienteDTO from(Paciente paciente){

        return new PacienteDTO(paciente.getNome(), paciente.getSobrenome(),
                paciente.getCpf(), paciente.getEmail(), paciente.getRg(),
                paciente.getProfissao(), paciente.getTelefone(), paciente.getCelular());

    }
}
