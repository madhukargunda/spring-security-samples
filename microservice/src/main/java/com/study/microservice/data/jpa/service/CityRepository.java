
package com.study.microservice.data.jpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.study.microservice.data.jpa.domain.City;

@RepositoryRestResource(collectionResourceRel = "citys", path = "cities")
interface CityRepository extends PagingAndSortingRepository<City, Long> {

	Page<City> findByNameContainingAndCountryContainingAllIgnoringCase(String name,
			String country, Pageable pageable);

	City findByNameAndCountryAllIgnoringCase(String name, String country);

}
