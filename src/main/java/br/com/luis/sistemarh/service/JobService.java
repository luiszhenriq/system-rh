package br.com.luis.sistemarh.service;

import br.com.luis.sistemarh.dto.job.JobRequestDTO;
import br.com.luis.sistemarh.dto.job.JobResponseDTO;
import br.com.luis.sistemarh.dto.job.JobUpdateDTO;
import br.com.luis.sistemarh.exception.IdNotFoundException;
import br.com.luis.sistemarh.models.Job;
import br.com.luis.sistemarh.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class JobService {

    @Autowired
    private JobRepository repository;



    public JobResponseDTO addJob(JobRequestDTO jobRequestDTO) {
        Job newJob = new Job(jobRequestDTO);

        Job saveJob = repository.save(newJob);

        return new JobResponseDTO(saveJob.getId(), saveJob.getCompany(), saveJob.getDescription(), saveJob.getRequirement(),
                saveJob.getSalary());
    }

    public List<Job> getAllJobs() {
        return repository.findAll();
    }

    public Job getJobById(Long id) {
        Optional<Job> job = repository.findById(id);
        if (job.isPresent()) {
            return job.get();
        }
        throw new IdNotFoundException("Não foi encontrado nenhuma Vaga");
    }

    public JobResponseDTO updateJob (Long id, JobUpdateDTO jobUpdateDTO) {
        Job job = repository.findById(id).
                orElseThrow(()-> new IdNotFoundException("Nenhuma vaga foi encontrada"));


        job.setDescription(jobUpdateDTO.description());
        job.setSalary(jobUpdateDTO.salary());
        Job updatedJob = repository.save(job);

        return new JobResponseDTO(updatedJob.getId(), updatedJob.getCompany(), updatedJob.getDescription(), updatedJob.getRequirement(),
                updatedJob.getSalary());
    }

    public void deleteJobById(Long id) {
        repository.deleteById(id);
    }

}
