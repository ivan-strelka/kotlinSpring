package ru.strelka.dto

import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

@Schema(description = "Информация о стране")
data class CountryDto(
    @Schema(description = "Идентификатор")
    @Min(1)
    @Max(Int.MAX_VALUE.toLong())
    val id: Int? = null,

    @Schema(description = "Имя")
    @NotBlank
    val name: String,

    @Schema(description = "Население")
    @NotBlank
    val population: Int,

    @Schema(description = "Города")
    @NotBlank
    val cities: List<CityDto>
)
