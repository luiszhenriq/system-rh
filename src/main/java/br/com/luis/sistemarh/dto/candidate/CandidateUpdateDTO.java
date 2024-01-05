package br.com.luis.sistemarh.dto.candidate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CandidateUpdateDTO(
        @NotBlank(message = "Email é um campo obrigatório")
        @Email
        String email,
        @NotBlank(message = "Telefone é um campo obrigatório")
        String numberPhone) {
}
