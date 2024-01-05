package br.com.luis.sistemarh.dto.candidate;

import br.com.luis.sistemarh.models.Job;

public record CandidateResponseDTO(Long id, String name, String rg, String email, String numberPhone, Job job) {
}
