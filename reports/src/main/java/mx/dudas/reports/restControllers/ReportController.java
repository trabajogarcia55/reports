package mx.dudas.reports.restControllers;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.dudas.reports.Services.ReportService;
import mx.dudas.reports.dtos.CotizacionDTO;
import mx.dudas.reports.dtos.DetalleCotizacionDTO;

@RestController
@RequestMapping("/api")
public class ReportController {
	private ReportService reportService;
	
	public ReportController(ReportService reportService) {
		this.reportService = reportService;
	}
	
	//http://localhost:8080/api/report
	@GetMapping("/report")
	public ResponseEntity<byte[]> generarReport() {
	    try {
	        byte[] report = reportService.generarReport("prueba13", 2);

	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_PDF);
	        headers.add(
	                HttpHeaders.CONTENT_DISPOSITION,
	                "inline; filename=prueba13.pdf"
	        );

	        return new ResponseEntity<>(report, headers, HttpStatus.OK);

	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.internalServerError().build();
	    }
	}
	
	// http://localhost:8080/api/cotizaciones
	@GetMapping("/cotizaciones")
	public ResponseEntity<List<CotizacionDTO>> listarCotizaciones() {
		List<CotizacionDTO> cotizaciones = reportService.getAllCotizaciones();
		
	    return ResponseEntity.ok(cotizaciones);
	}
	
	// http://localhost:8080/api/{cotizacionId}
	@GetMapping("/{cotizacionId}")
	private ResponseEntity<CotizacionDTO> findClienteById(@PathVariable Integer cotizacionId) {
		//logger.info("findCotizacionById {}", cotizacionId);
		CotizacionDTO cotizacion = reportService.findCotizacionById(cotizacionId);

		if (cotizacion != null) {
			return ResponseEntity.ok(cotizacion);
		}

		return ResponseEntity.notFound().build();
	}
	
	// http://localhost:8080/api/cotizaciones/{id}/detalles
	@GetMapping("/{cotizacionId}/detalles")
	public ResponseEntity<List<DetalleCotizacionDTO>> getDetallesByCotizacionId(
            @PathVariable Integer cotizacionId) {

        return ResponseEntity.ok(
                reportService.findDetallesByCotizacionId(cotizacionId)
        );
    }
	
}
