package br.com.luis.sistemarh.models;


import br.com.luis.sistemarh.dto.candidate.CandidateRequestDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "candidates")
@Table(name = "candidates")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String rg;

    @Column(unique = true)
    private String email;

    @Column(name = "number_phone")
    private String numberPhone;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_job")
    private Job job;

    public Candidate(CandidateRequestDTO candidateRequestDTO) {
        this.name = candidateRequestDTO.name();
        this.rg = candidateRequestDTO.rg();
        this.email = candidateRequestDTO.email();
        this.numberPhone = candidateRequestDTO.numberPhone();
    }
}
