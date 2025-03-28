package com.hawoon.api.dto.response;

import com.hawoon.domain.dto.MovieScheduleDto;

import java.time.LocalDateTime;

public record ScheduleResponseDto(
        LocalDateTime startAt,
        LocalDateTime endAt
) {
    public static ScheduleResponseDto from(MovieScheduleDto dto) {
        return new ScheduleResponseDto(
                dto.getStartAt(),
                dto.getEndAt()
        );
    }
}
