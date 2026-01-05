package mx.dudas.reports.Services;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import mx.dudas.reports.dtos.CotizacionDTO;
import mx.dudas.reports.dtos.CotizacionDetalleDTO;
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
    
    // metodo que generar el pdf
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
    
    public CotizacionDetalleDTO findCotizacionConDetalles(Integer cotizacionId) {

        Cotizacion cotizacion = cotizacionRepository.findById(cotizacionId)
                .orElse(null);

        if (cotizacion == null) {
            return null;
        }

        // Mapear cabecera
        CotizacionDetalleDTO dto = new CotizacionDetalleDTO();
        dto.setIdCotizacion(cotizacion.getIdCotizacion());
        dto.setFechaEmision(cotizacion.getFechaEmision());
        dto.setFechaVencimiento(cotizacion.getFechaVencimiento());
        dto.setSubtotal(cotizacion.getSubtotal());
        dto.setIva(cotizacion.getIva());
        dto.setTotalGeneral(cotizacion.getTotalGeneral());
        dto.setClienteProspecto(cotizacion.getClienteProspecto());
        dto.setVendedor(cotizacion.getVendedor());
        dto.setGarantia(cotizacion.getGarantia());
        dto.setDetalleCostos(cotizacion.getDetalleCostos());
        dto.setDetalleTabla(cotizacion.getDetalleTabla());
        dto.setSaludo(cotizacion.getSaludo());

        // Mapear detalles
        dto.setDetalles(
            detalleCotizacionMapper.toDTOList(
                detalleCotizacionRepository
                    .findByCotizacion_IdCotizacion(cotizacionId)
            )
        );
        
        return dto;
    }

   

    
    
    
    
}

