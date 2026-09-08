package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.ReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	private final LocalDate TODAY = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}


	public Page<ReportDTO> report(
			String minDate,
			String maxDate,
			String name,
			Pageable pageable
	) {

        LocalDate maxDateFinal;
		LocalDate minDateFinal;

        if(maxDate == null){
			maxDateFinal = TODAY;
		} else {
			maxDateFinal = LocalDate.parse(maxDate);
		}

		if(minDate == null){
			minDateFinal = maxDateFinal.minusYears(1L);
		} else {
			minDateFinal = LocalDate.parse(minDate);
		}

		if(name == null) {
			name = "";
		}

		Page<ReportDTO> listaReport = repository.report(maxDateFinal, minDateFinal, name, pageable);

		return listaReport;
	}
}
