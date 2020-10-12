package com.search.starter.exchange;

import com.search.starter.data.JobsEntity;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobResponse {
    private List<JobsEntity> jobs;
}