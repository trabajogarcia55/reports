package mx.dudas.reports.Services;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import mx.dudas.reports.dtos.CotizacionDTO;
import mx.dudas.reports.mappers.CotizacionDetalleMapper;
import mx.dudas.reports.mappers.CotizacionMapper;
import mx.dudas.reports.repositories.CotizacionRepository;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;


@Service
public class ReportService {

    private final DataSource dataSource;
    private final CotizacionRepository cotizacionRepository;
    private final CotizacionMapper cotizacionMapper;
    private final CotizacionDetalleMapper detalleCotizacionMapper;

    public ReportService( DataSource dataSource, CotizacionMapper cotizacionMapper, CotizacionRepository cotizacionRepository, CotizacionDetalleMapper detalleCotizacionMapper) {
        this.dataSource = dataSource;
        this.cotizacionMapper = cotizacionMapper;
        this.cotizacionRepository = cotizacionRepository;
        this.detalleCotizacionMapper = detalleCotizacionMapper;
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
    
    
}

