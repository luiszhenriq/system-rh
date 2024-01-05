package br.com.luis.sistemarh.dto.job;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record JobUpdateDTO(
        @NotBlank(message = "Descrição da vaga é um campo obrigatório")
        String description,

        @NotNull(message = "Salário é um campo obrigatório")
        Double salary) {
}
