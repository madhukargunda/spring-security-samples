
package com.study.microservice.data.jpa.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.study.microservice.data.jpa.domain.City;
import com.study.microservice.data.jpa.domain.Hotel;

@RepositoryRestResource(collectionResourceRel = "hotels", path = "hotels")
interface HotelRepository extends PagingAndSortingRepository<Hotel, Long> {

	Hotel findByCityAndName(City city, String name);

}
