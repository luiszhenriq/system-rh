package br.com.luis.sistemarh.service;

import br.com.luis.sistemarh.dto.job.JobRequestDTO;
import br.com.luis.sistemarh.dto.job.JobResponseDTO;
import br.com.luis.sistemarh.dto.job.JobUpdateDTO;
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
        throw new RuntimeException("Não foi encontrado nenhuma Vaga");
    }

    public JobResponseDTO updateJob (Long id, JobUpdateDTO jobUpdateDTO) {
        Optional<Job> job = repository.findById(id);

        if (job.isEmpty()) {
            throw new RuntimeException("Não foi encontrado nenhuma Vaga");
        }

        Job findedJob = job.get();
        findedJob.setDescription(jobUpdateDTO.description());
        findedJob.setSalary(jobUpdateDTO.salary());

        Job updatedJob = repository.save(findedJob);

        return new JobResponseDTO(updatedJob.getId(), updatedJob.getCompany(), updatedJob.getDescription(), updatedJob.getRequirement(),
                updatedJob.getSalary());
    }

    public void deleteJobById(Long id) {
        repository.deleteById(id);
    }

}
