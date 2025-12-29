package mx.dudas.reports.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import mx.dudas.reports.dtos.DetalleCotizacionDTO;
import mx.dudas.reports.entities.DetalleCotizacion;

@Mapper(componentModel = "spring")
public interface CotizacionDetalleMapper {

    @Mapping(source = "cotizacion.idCotizacion", target = "idCotizacion")
    DetalleCotizacionDTO toDTO(DetalleCotizacion entity);

    @Mapping(target = "cotizacion", ignore = true)
    DetalleCotizacion toEntity(DetalleCotizacionDTO dto);

    List<DetalleCotizacionDTO> toDTOList(List<DetalleCotizacion> entities);
}
