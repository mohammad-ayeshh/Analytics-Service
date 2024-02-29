package com.example.Analytics.Service.Statistics;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Statistics {
    @Id
    private String id;
    private double maxGrade;
    private double minGrade;
    private double averageGrade;

}
