package com.fisio.demo.paciente.api.dto;

import com.fisio.demo.paciente.domain.avaliacao.Avaliacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvaliacaoDto {

    private UUID id;
    private String queixa;
    private String tratamento;
    private String avaliacao;

    private LocalDate criadoEm;

    public static AvaliacaoDto from(Avaliacao avaliacao) {
        return AvaliacaoDto.builder()
                .id(avaliacao.getId())
                .queixa(avaliacao.getQueixa())
                .tratamento(avaliacao.getTratamento())
                .avaliacao(avaliacao.getDescricao())
                .criadoEm(avaliacao.getCriadoEm())
                .build();
    }
}