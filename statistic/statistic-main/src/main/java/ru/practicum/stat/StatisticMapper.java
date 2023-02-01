package ru.practicum.stat;

import org.mapstruct.Mapper;
import ru.practicum.dto.StatisticDtoIncom;
import ru.practicum.stat.model.Statistic;

@Mapper(componentModel = "spring")
public interface StatisticMapper {
    Statistic convertDtoToStatistic(StatisticDtoIncom statisticDtoIncom);
}

