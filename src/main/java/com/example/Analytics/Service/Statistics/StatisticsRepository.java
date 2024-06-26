package com.example.Analytics.Service.Statistics;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StatisticsRepository extends MongoRepository<Statistics, String> {

    Optional<Statistics> findTopByOrderByIdAsc();
}
