package com.search.starter.data;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Job")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobsEntity {

  @Id
  private int id;
  private String companyName;
  private String jobTitle;
  private List<String> keywords;
  private String jobDescription;
  private String jobLocation;
}
