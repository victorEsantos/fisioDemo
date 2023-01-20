package com.fisio.demo.endereco.model;

import com.fisio.demo.paciente.PacienteUseCase;
import com.fisio.demo.paciente.domain.Paciente;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "endereco")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String cep;
    private String estado;
    private String cidade;
    private String endereco;
    private String numero;
    private String bairro;
    private String complemento;
    @OneToOne(mappedBy = "endereco")
    private Paciente paciente;

    public static Endereco from(PacienteUseCase.EnderecoCommand endereco) {
        return Endereco.builder()
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