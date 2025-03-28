package com.hawoon.api.dto.request;

import com.hawoon.domain.entity.Genre;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MovieSearchRequestDto (
    @NotNull(message = "상영관 ID는 필수입니다.")
    Long theater_id,

    @Size(max = 255, message = "제목은 255자 이하만 가능합니다.")
    String title,

    Genre genre
) {}
