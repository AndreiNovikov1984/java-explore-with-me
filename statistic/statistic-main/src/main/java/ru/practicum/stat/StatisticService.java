package ru.practicum.stat;

import org.springframework.stereotype.Service;
import ru.practicum.dto.StatisticDto;
import ru.practicum.dto.StatisticDtoIncom;
import ru.practicum.stat.model.Statistic;

import java.util.Collection;

@Service
public interface StatisticService {

    Collection<StatisticDto> getStats(String start, String end, String[] uris, boolean unique);

    Statistic postStat(StatisticDtoIncom statistic);
}
