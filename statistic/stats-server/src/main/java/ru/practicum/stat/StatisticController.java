package ru.practicum.stat;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.dto.EndpointHit;
import ru.practicum.dto.ViewStats;
import ru.practicum.stat.model.Statistic;

import java.util.Collection;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Slf4j
@Validated
public class StatisticController {
    private final StatisticService statisticService;

    @GetMapping("/stats")                                    // метод получения пользователя по Id
    public ResponseEntity<Collection<ViewStats>> getStats(@NonNull @RequestParam String start,
                                                          @NonNull @RequestParam String end,
                                                          @NonNull @RequestParam String[] uris,
                                                          @RequestParam(defaultValue = "false") boolean unique) {
        log.info("Get stats with start={}, end={}, uris={}, unique={}", start, end, uris, unique);
        return new ResponseEntity<>(statisticService.getStats(start, end, uris, unique), HttpStatus.OK);
    }

    @PostMapping("/hit")                         // метод добавления пользователя
    public ResponseEntity<Statistic> postStat(@RequestBody EndpointHit statistic) {
        log.info("Creating stat record {}", statistic);
        return new ResponseEntity<>(statisticService.postStat(statistic), HttpStatus.OK);
    }
}
