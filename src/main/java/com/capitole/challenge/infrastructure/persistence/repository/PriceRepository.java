package com.capitole.challenge.infrastructure.persistence.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capitole.challenge.infrastructure.persistence.entity.PriceEntity;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

	@Query(nativeQuery = true, 
			value = "SELECT top 1 * FROM Prices "
					+ "WHERE :date BETWEEN start_date AND end_date "
					+ "AND product_Id = :productId "
					+ "AND brand_Id = :brandId  "
					+ "ORDER BY priority DESC")
	PriceEntity getPriceProductByDateProductBrand(
			@Param("date") LocalDateTime date, 
			@Param("productId") Integer productId, 
			@Param("brandId") Integer brandId);

	boolean existsByProductId(Integer productId);
	
	boolean existsByBrandId(Integer brandId);
	
	PriceEntity findDistinctTop1ByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanOrderByPriorityDesc(Integer brandId, Integer productId, LocalDateTime startDate, LocalDateTime endDate);
	
}

