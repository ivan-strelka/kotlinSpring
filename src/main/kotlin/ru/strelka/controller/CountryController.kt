package ru.strelka.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.strelka.dto.CountryDto
import ru.strelka.service.CountryService

@RestController
@RequestMapping("/countries")
class CountryController(
    private val countryService: CountryService,
) {

    @GetMapping
    fun gelAll(@RequestParam("page") pageIndex: Int): List<CountryDto> = countryService.gelAll(pageIndex)

}