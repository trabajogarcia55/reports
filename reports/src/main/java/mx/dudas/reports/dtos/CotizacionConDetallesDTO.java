package mx.dudas.reports.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CotizacionConDetallesDTO {
	private Integer idCotizacion;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private BigDecimal subtotal;
    private BigDecimal iva;
    private BigDecimal totalGeneral;
    private String clienteProspecto;
    private String vendedor;

    private List<DetalleCotizacionDTO> detalles;

	public Integer getIdCotizacion() {
		return idCotizacion;
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

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
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

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public List<DetalleCotizacionDTO> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleCotizacionDTO> detalles) {
		this.detalles = detalles;
	}
    
    
}
