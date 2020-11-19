package com.spring.currency_exchange.repository;

import com.spring.currency_exchange.model.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatsRepository extends JpaRepository<Stats, Long> {
    List<Stats> findBySum(Double sum);

    List<Stats> findBySumLessThan(Double sum);

    List<Stats> findBySumGreaterThan(Double sum);

    List<Stats> findBySumBetween(Double sum1, Double sum2);
}
