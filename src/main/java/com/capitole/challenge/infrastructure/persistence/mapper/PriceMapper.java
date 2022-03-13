package com.capitole.challenge.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;

import com.capitole.challenge.domian.api.entity.Price;
import com.capitole.challenge.infrastructure.persistence.entity.PriceEntity;

@Mapper(componentModel = "spring")
public abstract class PriceMapper {
	public abstract Price mapFromPersistence (PriceEntity entity);
	public abstract PriceEntity mapToPersistence (Price bo);
}