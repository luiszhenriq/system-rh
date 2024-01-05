package br.com.luis.sistemarh.dto.job;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record JobRequestDTO(
        @NotBlank(message = "Nome da empresa é um campo obrigatório")
        String company,
        @NotBlank(message = "Descrição da vaga é um campo obrigatório")
        String description,

        String requirement,
        @NotNull(message = "Salário é um campo obrigatório")
        Double salary) {


}
