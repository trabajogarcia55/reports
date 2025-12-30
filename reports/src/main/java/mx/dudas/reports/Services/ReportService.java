package mx.dudas.reports.Services;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import mx.dudas.reports.dtos.CotizacionConDetallesDTO;
import mx.dudas.reports.dtos.CotizacionDTO;
import mx.dudas.reports.dtos.DetalleCotizacionDTO;
import mx.dudas.reports.entities.Cotizacion;
import mx.dudas.reports.mappers.CotizacionDetalleMapper;
import mx.dudas.reports.mappers.CotizacionMapper;
import mx.dudas.reports.repositories.CotizacionRepository;
import mx.dudas.reports.repositories.DetalleCotizacionRepository;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;


@Service
public class ReportService {

    private final DataSource dataSource;
    private final CotizacionRepository cotizacionRepository;
    private final DetalleCotizacionRepository detalleCotizacionRepository;
    private final CotizacionMapper cotizacionMapper;
    private final CotizacionDetalleMapper detalleCotizacionMapper;

    public ReportService( DataSource dataSource, CotizacionMapper cotizacionMapper, CotizacionRepository cotizacionRepository, CotizacionDetalleMapper detalleCotizacionMapper, DetalleCotizacionRepository detalleCotizacionRepository) {
        this.dataSource = dataSource;
        this.cotizacionMapper = cotizacionMapper;
        this.cotizacionRepository = cotizacionRepository;
        this.detalleCotizacionMapper = detalleCotizacionMapper;
        this.detalleCotizacionRepository = detalleCotizacionRepository;
    }
    
    // metodo que generqa el pdf
    public byte[] generarReport(String reportName, Integer idCotizacion)
            throws JRException, SQLException {

        InputStream reportStream = getClass()
                .getResourceAsStream("/reports/" + reportName + ".jasper");

        if (reportStream == null) {
            throw new RuntimeException("No se encontró el reporte .jasper");
        }

        Map<String, Object> params = new HashMap<>();
        params.put("idCotizacion", idCotizacion);
        
        params.put("SUBREPORT_DIR", "/reports/");

        JasperPrint jasperPrint = JasperFillManager.fillReport(
                reportStream,
                params,
                dataSource.getConnection()
        );

        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
    
    // Listar cotizaciones
    public List<CotizacionDTO> getAllCotizaciones() {
        return cotizacionMapper.toDTOList(cotizacionRepository.findAll());
    }
    
    //Buscar cotizacion por id
    public CotizacionDTO findCotizacionById(Integer cotizacionId) {
		Optional<Cotizacion> result = cotizacionRepository.findById(cotizacionId);

		if (result.isPresent()) {
			return cotizacionMapper.toDTO(result.get());
		}

		return null;
	}
    
    //Detalles de la cotizacion buscada
    public List<DetalleCotizacionDTO> findDetallesByCotizacionId(Integer idCotizacion) {
        return detalleCotizacionMapper.toDTOList(
                detalleCotizacionRepository.findByCotizacion_IdCotizacion(idCotizacion)
        );
    }
    
    public List<CotizacionConDetallesDTO> getCotizacionesConDetalles() {
    	return cotizacionRepository.findAll()
                .stream()
                .map(cotizacion -> {

                    CotizacionConDetallesDTO dto = new CotizacionConDetallesDTO();

                    // 1️⃣ Mapear cotización
                    CotizacionDTO cotizacionDTO = cotizacionMapper.toDTO(cotizacion);

                    dto.setIdCotizacion(cotizacionDTO.getIdCotizacion());
                    dto.setFechaEmision(cotizacionDTO.getFechaEmision());
                    dto.setFechaVencimiento(cotizacionDTO.getFechaVencimiento());
                    dto.setSubtotal(cotizacionDTO.getSubtotal());
                    dto.setIva(cotizacionDTO.getIva());
                    dto.setTotalGeneral(cotizacionDTO.getTotalGeneral());
                    dto.setClienteProspecto(cotizacionDTO.getClienteProspecto());
                    dto.setVendedor(cotizacionDTO.getVendedor());

                    // 2️⃣ Obtener y mapear detalles
                    List<DetalleCotizacionDTO> detalles =
                            detalleCotizacionMapper.toDTOList(
                                    detalleCotizacionRepository
                                            .findByCotizacion_IdCotizacion(
                                                    cotizacion.getIdCotizacion()
                                            )
                            );

                    dto.setDetalles(detalles);

                    return dto;
                })
                .toList();
    }
    
    
    
}

