package com.example.Analytics.Service.Statistics;

import com.example.Analytics.Service.grade.Grade;
import com.example.Analytics.Service.grade.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatisticsService {
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private StatisticsRepository statisticsRepository;

    public void updateGradeAnalysis() {
        List<Grade> grades = gradeRepository.findAll();
        double max = grades.stream().mapToDouble(Grade::getValue).max().orElse(0);
        double min = grades.stream().mapToDouble(Grade::getValue).min().orElse(0);
        double avg = grades.stream().mapToDouble(Grade::getValue).average().orElse(0);


        Optional<Statistics> optionalAnalysis = statisticsRepository.findTopByOrderByIdAsc();

        Statistics analysis;
        if (optionalAnalysis.isPresent()) {
            analysis = optionalAnalysis.get();
            analysis.setMaxGrade(max);
            analysis.setMinGrade(min);
            analysis.setAverageGrade(avg);
        } else {
            analysis = new Statistics(null, max, min, avg);
        }

        statisticsRepository.save(analysis);
    }


    @Scheduled(fixedRate = 10000)
    public void scheduledUpdateGradeAnalysis() {
        System.out.println("Scheduled method runing");
        updateGradeAnalysis();
    }

}