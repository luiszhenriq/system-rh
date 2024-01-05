package br.com.luis.sistemarh.dto.job;

public record JobResponseDTO(Long id, String company, String description, String benefit, String requirement, Double salary) {
}
