package com.diviso.graeshoppe.report.service.mapper;

import com.diviso.graeshoppe.report.domain.*;
import com.diviso.graeshoppe.report.service.dto.AuxItemDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AuxItem} and its DTO {@link AuxItemDTO}.
 */
@Mapper(componentModel = "spring", uses = {OrderLineMapper.class})
public interface AuxItemMapper extends EntityMapper<AuxItemDTO, AuxItem> {

    @Override
	@Mapping(source = "orderLine.id", target = "orderLineId")
    AuxItemDTO toDto(AuxItem auxItem);

    @Override
	@Mapping(source = "orderLineId", target = "orderLine")
    AuxItem toEntity(AuxItemDTO auxItemDTO);

    default AuxItem fromId(Long id) {
        if (id == null) {
            return null;
        }
        AuxItem auxItem = new AuxItem();
        auxItem.setId(id);
        return auxItem;
    }
}
