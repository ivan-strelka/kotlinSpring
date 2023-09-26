package ru.strelka.repository

import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import ru.strelka.entity.CountryEntity
import ru.strelka.model.NameOnly


interface CountryRepo : CrudRepository<CountryEntity, Int> {

    fun findByOrderByName(pageable: Pageable): List<CountryEntity>

    fun findByNameStartsWithIgnoreCaseOrderByName(prefix: String): List<CountryEntity>

    fun findAllByOrderByName(): List<NameOnly>
}