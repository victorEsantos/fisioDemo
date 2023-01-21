package com.fisio.demo.paciente.api.dto;

import com.fisio.demo.paciente.domain.convenio.enums.ConvenioEnum;
import com.fisio.demo.paciente.domain.evolucao.Evolucao;
import com.fisio.demo.paciente.domain.evolucao.Procedimento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvolucaoDto {

    private UUID id;
    private LocalDateTime atendimentoDe;
    private LocalDateTime atendimentoAte;
    private ConvenioEnum convenio;
    private String senhaAutenticador;
    private Procedimento procedimento;
    private String descricao;

    public static EvolucaoDto from(Evolucao evolucao) {
        return EvolucaoDto.builder()
                .id(evolucao.getId())
                .atendimentoDe(evolucao.getAtendimentoDe())
                .atendimentoAte(evolucao.getAtendimentoAte())
                .convenio(evolucao.getConvenio())
                .senhaAutenticador(evolucao.getSenhaAutenticador())
                .procedimento(evolucao.getProcedimento())
                .descricao(evolucao.getDescricao())
                .build();
    }
}