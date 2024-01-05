package br.com.luis.sistemarh.dto.candidate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CandidateRequestDTO(
        @NotBlank(message = "Nome é um campo obrigatório")
        String name,
        @NotBlank(message = "Rg é um campo obrigatório")
        String rg,
        @NotBlank(message = "Email é um campo obrigatório")
        @Email
        String email,
        @NotBlank(message = "Telefone é um campo obrigatório")
        String numberPhone,
        @NotNull(message = "O código da vaga é obrigatório")
        Long jobId) {
}
