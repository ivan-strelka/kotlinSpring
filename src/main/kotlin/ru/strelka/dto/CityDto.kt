package ru.strelka.dto

import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotBlank

@Schema(description = "Информация о городе")
data class CityDto(
    @Schema(description = "Имя")
    @NotBlank
    val name: String
)
