package br.com.luis.sistemarh.service;


import br.com.luis.sistemarh.dto.candidate.CandidateRequestDTO;
import br.com.luis.sistemarh.dto.candidate.CandidateResponseDTO;
import br.com.luis.sistemarh.dto.candidate.CandidateUpdateDTO;
import br.com.luis.sistemarh.models.Candidate;
import br.com.luis.sistemarh.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {


    @Autowired
    private CandidateRepository repository;


    public CandidateResponseDTO addCandidate(CandidateRequestDTO candidate) {

        Candidate newCandidate = new Candidate(candidate);

        Candidate saveCandidate = repository.save(newCandidate);

        return new CandidateResponseDTO(saveCandidate.getId(), saveCandidate.getName(), saveCandidate.getRg(), saveCandidate.getEmail(),
                saveCandidate.getNumberPhone());
    }

    public List<Candidate> getAllCandidates() {
        return repository.findAll();
    }

    public Candidate getCandidateFindById (Long id) {
        Optional<Candidate> candidate = repository.findById(id);

        if (candidate.isEmpty()) {
            throw new RuntimeException("Não foi encontrado nenhum candidato");
        }

        return candidate.get();

    }

    public CandidateResponseDTO updateCandidate (Long id, CandidateUpdateDTO candidateUpdateDTO) {
        Optional<Candidate> candidate = repository.findById(id);

        if (candidate.isEmpty()) {
            throw new RuntimeException("Não foi encontrado nenhum candidato");
        }

        Candidate findedCandidate = candidate.get();
        findedCandidate.setEmail(candidateUpdateDTO.email());
        findedCandidate.setNumberPhone(candidateUpdateDTO.numberPhone());

        Candidate updatedCandidate = repository.save(findedCandidate);

        return new CandidateResponseDTO(updatedCandidate.getId(), updatedCandidate.getName(), updatedCandidate.getRg(), updatedCandidate.getEmail(),
                updatedCandidate.getNumberPhone());
    }

    public void deleteById (Long id) {
        repository.deleteById(id);
    }
}
