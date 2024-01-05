package br.com.luis.sistemarh.controller;


import br.com.luis.sistemarh.dto.candidate.CandidateRequestDTO;
import br.com.luis.sistemarh.dto.candidate.CandidateResponseDTO;
import br.com.luis.sistemarh.dto.candidate.CandidateUpdateDTO;
import br.com.luis.sistemarh.models.Candidate;
import br.com.luis.sistemarh.service.CandidateService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {


    @Autowired
    private CandidateService service;

    @PostMapping
    @Transactional
    public ResponseEntity<CandidateResponseDTO> addCandidate (@RequestBody @Valid CandidateRequestDTO candidateRequestDTO) {
        return  new ResponseEntity<>(service.addCandidate(candidateRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        return new ResponseEntity<>(service.getAllCandidates(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.getCandidateFindById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CandidateResponseDTO> updateCandidate (@PathVariable("id") Long id, @RequestBody @Valid CandidateUpdateDTO candidateUpdateDTO) {
        return new ResponseEntity<>(service.updateCandidate(id, candidateUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCandidate(@PathVariable("id") Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
