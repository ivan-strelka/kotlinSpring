package ru.strelka.service.impl

import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import ru.strelka.dto.CountryDto
import ru.strelka.entity.CountryEntity
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

    private fun CountryEntity.toDto(): CountryDto {
        return CountryDto(
            id = this.id,
            name = this.name,
            population = this.population
        )
    }
}