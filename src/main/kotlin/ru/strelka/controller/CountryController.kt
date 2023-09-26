package ru.strelka.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.strelka.dto.CountryDto
import ru.strelka.service.CountryService

@RestController
@RequestMapping("/countries")
@Tag(
    name = "Страны",
    description = "Все методы для работы со странами",
)
class CountryController(
    private val countryService: CountryService,
) {
    @GetMapping
    @Operation(summary = "Получить все страны")
    fun gelAll(
        @Parameter(description = "номер страницы")
        @RequestParam("page") pageIndex: Int
    ): List<CountryDto> =
        countryService.gelAll(pageIndex)

    @GetMapping("/{id}")
    @Operation(summary = "Найти страну по Id")
    fun getById(
        @Parameter(description = "id пользователя")
        @PathVariable("id") id: Int
    ): CountryDto =
        countryService.findById(id)

    @GetMapping("/search")
    @Operation(summary = "Найти страну по названию")
    fun searchCountries(
        @Parameter(description = "префикс страны")
        @RequestParam("prefix") prefix: String
    ): List<CountryDto> = countryService.search(prefix)

    @GetMapping("/names")
    @Operation(summary = "Получить список всех стран")
    fun getCountyNames(): List<String> = countryService.getCountyNames()

    @PostMapping
    @Operation(summary = "Создать страну")
    fun create(
        @RequestBody dto: CountryDto
    ): Int {
        return countryService.create(dto)
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить страну по id")
    fun update(
        @Parameter(description = "id пользователя")
        @PathVariable id: Int,
        @RequestBody dto: CountryDto
    ): CountryDto {
        return countryService.update(id, dto)
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить страну по id")
    fun delete(
        @Parameter(description = "id пользователя")
        @PathVariable id: Int) {
        countryService.delete(id)
    }

}