package ru.strelka.service.impl

import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.strelka.dto.CityDto
import ru.strelka.dto.CountryDto
import ru.strelka.entity.CityEntity
import ru.strelka.entity.CountryEntity
import ru.strelka.exception.CountryNotFoundException
import ru.strelka.repository.CountryRepo
import ru.strelka.service.CountryService

@Service
class CountryServiceImpl(
    private val countryRepo: CountryRepo,
) : CountryService {
    override fun gelAll(pageIndex: Int): List<CountryDto> {
        return countryRepo.findByOrderByName(PageRequest.of(pageIndex, 3)).map {
            it.toDto()
        }
    }

    override fun findById(id: Int): CountryDto {
        return countryRepo.findByIdOrNull(id)
            ?.toDto()
            ?: throw CountryNotFoundException(id)
    }

    override fun search(prefix: String): List<CountryDto> {
        return countryRepo.findByNameStartsWithIgnoreCaseOrderByName(prefix).map { it.toDto() }

    }

    override fun create(dto: CountryDto): Int {
        return countryRepo.save(dto.toEntity()).id
    }

    override fun update(id: Int, dto: CountryDto): CountryDto {
        val existingCountry = countryRepo.findByIdOrNull(id) ?: throw CountryNotFoundException(id)
        existingCountry.name = dto.name
        existingCountry.population = dto.population
        return countryRepo.save(existingCountry).toDto()
    }

    override fun delete(id: Int) {
        val existingCountry = countryRepo.findByIdOrNull(id) ?: throw CountryNotFoundException(id)
        countryRepo.deleteById(existingCountry.id)
    }

    private fun CountryEntity.toDto(): CountryDto {
        return CountryDto(
            id = this.id,
            name = this.name,
            population = this.population,
            cities = this.cities.map { it.toDto() }
        )
    }

    private fun CityEntity.toDto(): CityDto =
        CityDto(
            name = this.name
        )

    private fun CountryDto.toEntity(): CountryEntity {
        return CountryEntity(
            id = 0,
            name = this.name,
            population = this.population

        )
    }
}