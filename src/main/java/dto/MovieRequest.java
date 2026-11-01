
package org.example.jpabook.week09_jpa_project.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MovieRequest(
        @NotBlank @Size(max = 200) String title,
        @NotBlank @Size(max = 100) String director,
        @NotBlank @Size(max = 50) String genre,
        @NotNull @Min(1900) @Max(2100) Integer releaseYear,
        @NotNull @Min(0) @Max(10) Double rating,
        @NotNull @Min(1) Integer runningTime
) {}
