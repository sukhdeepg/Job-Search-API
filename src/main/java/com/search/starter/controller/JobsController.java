package com.search.starter.controller;

import com.search.starter.exchange.JobRequest;
import com.search.starter.exchange.JobResponse;
import com.search.starter.repository.JobsRepository;
import com.search.starter.service.JobsService;
import com.search.starter.data.JobsEntity;
import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JobsController {

  @Autowired
  private JobsRepository repository;

  @Autowired
  private JobsService jobsService;

  @GetMapping("/alljobs")
  public List<JobsEntity> getAllJobs() {
    return repository.findAll();
  }

  @GetMapping("/jobs")
  public ResponseEntity<JobResponse> getJobs(JobRequest jobRequest) {
    JobResponse jobResponse = jobsService.getJobs(jobRequest.getJobLocation(), jobRequest.getKeywords());

    return ResponseEntity.ok().body(jobResponse);
  }

  @PostMapping("/jobs")
  public String addJob(@RequestBody JobsEntity job) {
    repository.save(job);
    return "Job added!";
  }

  @DeleteMapping("/delete/{id}")
  public String deleteJob(@PathVariable int id) {
    repository.deleteById(id);
    return "Job deleted with ID: " + id;
  }

}