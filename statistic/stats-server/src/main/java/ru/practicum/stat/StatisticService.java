package ru.practicum.stat;

import org.springframework.stereotype.Service;
import ru.practicum.dto.EndpointHit;
import ru.practicum.dto.ViewStats;
import ru.practicum.stat.model.Statistic;

import java.util.Collection;

@Service
public interface StatisticService {

    Collection<ViewStats> getStats(String start, String end, String[] uris, boolean unique);

    Statistic postStat(EndpointHit statistic);
}
