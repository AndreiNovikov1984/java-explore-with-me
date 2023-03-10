package ru.practicum.stat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.practicum.dto.ViewStats;
import ru.practicum.stat.model.Statistic;

import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Long> {

    @Query(value = "select new ru.practicum.dto.ViewStats(s.app, s.uri, count(s.ip)) " +
            "from Statistic as s " +
            "WHERE s.uri in ?3 " +
            "and s.timestamp between ?1 and ?2 " +
            "group by s.app, s.uri " +
            "order by count(s.app) desc ")
    Collection<ViewStats> findBetweenStartAndEndByUrisNonUnique(LocalDateTime start, LocalDateTime end, String[] uris);

    @Query(value = "select new ru.practicum.dto.ViewStats(s.app, s.uri, count(distinct s.ip)) " +
            "from Statistic as s " +
            "WHERE s.uri in ?3 " +
            "and s.timestamp between ?1 and ?2 " +
            "group by s.app, s.uri " +
            "order by count(s.app) desc ")
    Collection<ViewStats> findBetweenStartAndEndByUrisUnique(LocalDateTime start, LocalDateTime end, String[] uris);
}
