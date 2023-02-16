package ru.practicum.stat;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.dto.EndpointHit;
import ru.practicum.dto.ViewStats;
import ru.practicum.stat.model.Statistic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticServiceImpl implements StatisticService {
    private final StatisticRepository statisticRepository;
    private final StatisticMapper statisticMapper;

    @Override
    public Collection<ViewStats> getStats(String start, String end, String[] uris, boolean unique) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime starTime = LocalDateTime.parse(start, formatter);
        LocalDateTime endTime = LocalDateTime.parse(end, formatter);
        if (unique) {
            return statisticRepository.findBetweenStartAndEndByUrisUnique(starTime, endTime, uris);
        } else {
            return statisticRepository.findBetweenStartAndEndByUrisNonUnique(starTime, endTime, uris);
        }
    }

    @Override
    public Statistic postStat(EndpointHit statistic) {
        return statisticRepository.save(statisticMapper.convertDtoToStatistic(statistic));
    }
}
