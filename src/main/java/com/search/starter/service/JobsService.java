package com.search.starter.service;

import com.search.starter.data.JobsEntity;
import com.search.starter.exchange.JobResponse;
import com.search.starter.repository.JobsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface JobsService {
    public JobResponse getJobs(String jobLocation, List<String> keywords);
}
