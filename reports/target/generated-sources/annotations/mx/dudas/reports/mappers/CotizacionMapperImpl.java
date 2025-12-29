package mx.dudas.reports.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import mx.dudas.reports.dtos.CotizacionDTO;
import mx.dudas.reports.entities.Cotizacion;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-28T19:59:48-0600",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.v20250526-2018, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class CotizacionMapperImpl implements CotizacionMapper {

    @Override
    public CotizacionDTO toDTO(Cotizacion cotizacion) {
        if ( cotizacion == null ) {
            return null;
        }

        CotizacionDTO cotizacionDTO = new CotizacionDTO();

        cotizacionDTO.setIdCotizacion( cotizacion.getIdCotizacion() );
        cotizacionDTO.setFechaEmision( cotizacion.getFechaEmision() );
        cotizacionDTO.setFechaVencimiento( cotizacion.getFechaVencimiento() );
        cotizacionDTO.setSubtotal( cotizacion.getSubtotal() );
        cotizacionDTO.setIva( cotizacion.getIva() );
        cotizacionDTO.setTotalGeneral( cotizacion.getTotalGeneral() );
        cotizacionDTO.setClienteProspecto( cotizacion.getClienteProspecto() );
        cotizacionDTO.setVendedor( cotizacion.getVendedor() );

        return cotizacionDTO;
    }

    @Override
    public List<CotizacionDTO> toDTOList(List<Cotizacion> cotizaciones) {
        if ( cotizaciones == null ) {
            return null;
        }

        List<CotizacionDTO> list = new ArrayList<CotizacionDTO>( cotizaciones.size() );
        for ( Cotizacion cotizacion : cotizaciones ) {
            list.add( toDTO( cotizacion ) );
        }

        return list;
    }
}
