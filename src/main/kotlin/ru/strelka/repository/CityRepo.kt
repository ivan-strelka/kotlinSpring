package ru.strelka.repository

import org.springframework.data.repository.CrudRepository
import ru.strelka.entity.CityEntity
import ru.strelka.entity.CountryEntity

interface CityRepo : CrudRepository<CityEntity, Int> {

    fun deleteAllByCountry(country: CountryEntity)
}