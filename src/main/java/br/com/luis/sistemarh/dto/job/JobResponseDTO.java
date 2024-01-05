package br.com.luis.sistemarh.dto.job;

import java.util.List;

public record JobResponseDTO(Long id, String company, String description, String requirement, Double salary) {
}
