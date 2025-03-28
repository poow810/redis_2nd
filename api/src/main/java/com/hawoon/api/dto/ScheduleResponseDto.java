package com.hawoon.api.dto;

import com.hawoon.domain.dto.MovieScheduleDto;
import com.hawoon.domain.entity.Schedule;
import lombok.Builder;

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
