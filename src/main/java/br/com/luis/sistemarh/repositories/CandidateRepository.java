package br.com.luis.sistemarh.repositories;

import br.com.luis.sistemarh.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
