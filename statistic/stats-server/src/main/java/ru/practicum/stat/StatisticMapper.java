package ru.practicum.stat;

import org.mapstruct.Mapper;
import ru.practicum.dto.EndpointHit;
import ru.practicum.stat.model.Statistic;

@Mapper(componentModel = "spring")
public interface StatisticMapper {
    Statistic convertDtoToStatistic(EndpointHit endpointHit);
}

