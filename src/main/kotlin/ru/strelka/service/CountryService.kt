package ru.strelka.service

import ru.strelka.dto.CountryDto

interface CountryService {

    fun gelAll(pageIndex: Int): List<CountryDto>
}