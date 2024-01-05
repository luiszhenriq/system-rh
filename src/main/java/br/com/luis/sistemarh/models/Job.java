package br.com.luis.sistemarh.models;


import br.com.luis.sistemarh.dto.job.JobRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "jobs")
@Table(name = "jobs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;

    private String description;

    private String requirement;

    private Double salary;

    public Job(JobRequestDTO jobRequestDTO) {
        this.company = jobRequestDTO.company();
        this.description = jobRequestDTO.description();
        this.requirement = jobRequestDTO.requirement();
        this.salary = jobRequestDTO.salary();
    }
}
