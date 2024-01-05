package br.com.luis.sistemarh.repositories;

import br.com.luis.sistemarh.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
