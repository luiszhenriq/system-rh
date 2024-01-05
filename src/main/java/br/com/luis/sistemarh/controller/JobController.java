package br.com.luis.sistemarh.controller;


import br.com.luis.sistemarh.dto.job.JobRequestDTO;
import br.com.luis.sistemarh.dto.job.JobResponseDTO;
import br.com.luis.sistemarh.dto.job.JobUpdateDTO;
import br.com.luis.sistemarh.models.Job;
import br.com.luis.sistemarh.service.JobService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService service;


    @PostMapping
    @Transactional
    public ResponseEntity<JobResponseDTO> addJob(@RequestBody JobRequestDTO jobRequestDTO) {
        return new ResponseEntity<>(service.addJob(jobRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        return new ResponseEntity<>(service.getAllJobs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById (@PathVariable("id")Long id) {
        return new ResponseEntity<>(service.getJobById(id),HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteJobById(@PathVariable("id") Long id) {
        service.deleteJobById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<JobResponseDTO> updateJob (@PathVariable("id") Long id, @RequestBody JobUpdateDTO jobUpdateDTO) {
        return new ResponseEntity<>(service.updateJob(id, jobUpdateDTO), HttpStatus.OK);
    }
}
