package com.search.starter.service;

import com.search.starter.data.JobsEntity;
import com.search.starter.exchange.JobResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.ArrayList;

@Service
public class JobsServiceImpl implements JobsService {

    @Autowired
    private MongoTemplate mongoTemplate;

    private ModelMapper modelMapper = new ModelMapper();

    private boolean isJobMatch(List<String> neededKeywords, List<String> currKeywords) {

        for (String keyword : neededKeywords) {
            for (String currKeyword : currKeywords) {
                if (keyword.equals(currKeyword)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    @Override
    public JobResponse getJobs(String jobLocation, List<String> keywords) {
        
        Query query = new Query(Criteria.where("jobLocation").regex("^"+jobLocation+"$"));

        List<JobsEntity> jobs = mongoTemplate.find(query, JobsEntity.class);

        System.out.println(jobs);

        List<JobsEntity> neededJobs = new ArrayList<>();

        for (JobsEntity job : jobs) {
            List<String> currKeywords = job.getKeywords();

            boolean isMtach = isJobMatch(keywords, currKeywords);

            if (isMtach) {
                neededJobs.add(modelMapper.map(job, JobsEntity.class));
            }
          }

        JobResponse jobResponse = new JobResponse();
        jobResponse.setJobs(neededJobs);

        return jobResponse;        
    }

    
}