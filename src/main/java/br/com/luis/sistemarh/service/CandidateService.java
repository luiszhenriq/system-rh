package br.com.luis.sistemarh.service;


import br.com.luis.sistemarh.dto.candidate.CandidateRequestDTO;
import br.com.luis.sistemarh.dto.candidate.CandidateResponseDTO;
import br.com.luis.sistemarh.dto.candidate.CandidateUpdateDTO;
import br.com.luis.sistemarh.exception.IdNotFoundException;
import br.com.luis.sistemarh.models.Candidate;
import br.com.luis.sistemarh.models.Job;
import br.com.luis.sistemarh.repositories.CandidateRepository;
import br.com.luis.sistemarh.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {


    @Autowired
    private CandidateRepository repository;

    @Autowired
    private JobRepository jobRepository;


    public CandidateResponseDTO addCandidate(CandidateRequestDTO candidate) {
        Job job = jobRepository.findById(candidate.jobId())
                .orElseThrow(()-> new IdNotFoundException("Vaga não encontrada"));



        Candidate newCandidate = new Candidate(candidate);
        newCandidate.setJob(job);
        Candidate saveCandidate = repository.save(newCandidate);

        return new CandidateResponseDTO(saveCandidate.getId(), saveCandidate.getName(), saveCandidate.getRg(), saveCandidate.getEmail(),
                saveCandidate.getNumberPhone(),saveCandidate.getJob());
    }

    public List<Candidate> getAllCandidates() {
        return repository.findAll();
    }

    public Candidate getCandidateFindById (Long id) {
        Optional<Candidate> candidate = repository.findById(id);

        if (candidate.isEmpty()) {
            throw new IdNotFoundException("Não foi encontrado nenhum candidato com esse ID: " + id);
        }

        return candidate.get();

    }

    public CandidateResponseDTO updateCandidate (Long id, CandidateUpdateDTO candidateUpdateDTO) {
        Candidate candidate = repository.findById(id).get();

        if (candidateUpdateDTO.email() != null) {
            candidate.setEmail(candidateUpdateDTO.email());
        }

        if (candidateUpdateDTO.numberPhone() != null) {
            candidate.setNumberPhone(candidateUpdateDTO.numberPhone());
        }

        Candidate updatedCandidate = repository.save(candidate);

        return new CandidateResponseDTO(updatedCandidate.getId(), updatedCandidate.getName(), updatedCandidate.getRg(), updatedCandidate.getEmail(),
                updatedCandidate.getNumberPhone(), updatedCandidate.getJob());
    }

    public void deleteById (Long id) {
        repository.deleteById(id);
    }
}
