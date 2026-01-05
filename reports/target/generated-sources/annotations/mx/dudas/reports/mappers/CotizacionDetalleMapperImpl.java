package mx.dudas.reports.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import mx.dudas.reports.dtos.DetalleCotizacionDTO;
import mx.dudas.reports.entities.Cotizacion;
import mx.dudas.reports.entities.DetalleCotizacion;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-04T20:56:56-0600",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.v20250526-2018, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class CotizacionDetalleMapperImpl implements CotizacionDetalleMapper {

    @Override
    public DetalleCotizacionDTO toDTO(DetalleCotizacion entity) {
        if ( entity == null ) {
            return null;
        }

        DetalleCotizacionDTO detalleCotizacionDTO = new DetalleCotizacionDTO();

        detalleCotizacionDTO.setIdCotizacion( entityCotizacionIdCotizacion( entity ) );
        detalleCotizacionDTO.setIdDetalleCotizacion( entity.getIdDetalleCotizacion() );
        detalleCotizacionDTO.setDescripcion( entity.getDescripcion() );
        detalleCotizacionDTO.setPrecioUnitario( entity.getPrecioUnitario() );
        detalleCotizacionDTO.setImporte( entity.getImporte() );
        detalleCotizacionDTO.setCantidad( entity.getCantidad() );

        return detalleCotizacionDTO;
    }

    @Override
    public List<DetalleCotizacionDTO> toDTOList(List<DetalleCotizacion> entities) {
        if ( entities == null ) {
            return null;
        }

        List<DetalleCotizacionDTO> list = new ArrayList<DetalleCotizacionDTO>( entities.size() );
        for ( DetalleCotizacion detalleCotizacion : entities ) {
            list.add( toDTO( detalleCotizacion ) );
        }

        return list;
    }

    private Integer entityCotizacionIdCotizacion(DetalleCotizacion detalleCotizacion) {
        Cotizacion cotizacion = detalleCotizacion.getCotizacion();
        if ( cotizacion == null ) {
            return null;
        }
        return cotizacion.getIdCotizacion();
    }
}
