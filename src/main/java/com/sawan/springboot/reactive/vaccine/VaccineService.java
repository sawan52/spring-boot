package com.sawan.springboot.reactive.vaccine;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class VaccineService {

	public Flux<Vaccine> getVaccines() {
		return Flux.just(new Vaccine("Pfizer"), new Vaccine("Covishield"), 
				new Vaccine("Covaxin"), new Vaccine("J&J"));
	}

}
