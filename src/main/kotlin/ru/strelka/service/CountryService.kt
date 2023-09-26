package ru.strelka.service

import ru.strelka.dto.CountryDto

interface CountryService {

    fun gelAll(pageIndex: Int): List<CountryDto>

    fun findById(id: Int): CountryDto

    fun search(prefix: String): List<CountryDto>

    fun create(dto: CountryDto): Int

    fun update(id: Int, dto: CountryDto): CountryDto

    fun delete(id: Int)

    fun getCountyNames():List<String>
}