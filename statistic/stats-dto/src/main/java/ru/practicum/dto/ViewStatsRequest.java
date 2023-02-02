package ru.practicum.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViewStatsRequest {
    private Set<String> uris;
    private LocalDateTime start;
    private LocalDateTime end;
    private boolean unique;
    private Integer limit;
    private String application;
}
