package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.ReportDTO;
import com.devsuperior.dsmeta.dto.SummaryDTO;
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

        LocalDate maxDateFinal = this.dataMaxFinal(maxDate);
		LocalDate minDateFinal = this.dataMinFinal(minDate, maxDateFinal);

		if(name == null) {
			name = "";
		}

        return repository.report(maxDateFinal, minDateFinal, name, pageable);

	}

	public List<SummaryDTO> summary(
			String minDate,
			String maxDate
	) {

		LocalDate maxDateFinal = this.dataMaxFinal(maxDate);
		LocalDate minDateFinal = this.dataMinFinal(minDate,maxDateFinal);

        return repository.summary(maxDateFinal, minDateFinal);
	}

	private LocalDate dataMaxFinal(String dataMax) {
		if(dataMax == null){
			return TODAY;
		} else {
			return LocalDate.parse(dataMax);
		}
	}

	private LocalDate dataMinFinal(String dataMin, LocalDate maxDateFinal) {
		if(dataMin == null){
			return maxDateFinal.minusYears(1L);
		} else {
			return LocalDate.parse(dataMin);
		}
	}

}
