package mx.dudas.reports.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CotizacionConDetallesDTO {//dto para buscar o crear usuario. agregar mas datos que faltan
	private Integer idCotizacion;
    private BigDecimal subtotal;
    private BigDecimal iva;
    private String vendedor;
    
    private String clienteProspecto;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private String garantia;
    private BigDecimal totalGeneral;

    private List<DetalleCotizacionDTO> detalles;

	public Integer getIdCotizacion() {
		return idCotizacion;
	}

	public String getGarantia() {
		return garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public void setIdCotizacion(Integer idCotizacion) {
		this.idCotizacion = idCotizacion;
	}

	public LocalDate getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(LocalDate fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public BigDecimal getTotalGeneral() {
		return totalGeneral;
	}

	public void setTotalGeneral(BigDecimal totalGeneral) {
		this.totalGeneral = totalGeneral;
	}

	public String getClienteProspecto() {
		return clienteProspecto;
	}

	public void setClienteProspecto(String clienteProspecto) {
		this.clienteProspecto = clienteProspecto;
	}

	public List<DetalleCotizacionDTO> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleCotizacionDTO> detalles) {
		this.detalles = detalles;
	}
    
    
}
