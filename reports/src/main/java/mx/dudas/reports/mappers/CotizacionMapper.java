package mx.dudas.reports.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import mx.dudas.reports.dtos.CotizacionDTO;
import mx.dudas.reports.entities.Cotizacion;


@Mapper(componentModel = "spring")
public interface CotizacionMapper {
	CotizacionDTO toDTO(Cotizacion cotizacion);

    List<CotizacionDTO> toDTOList(List<Cotizacion> cotizaciones); 
}
