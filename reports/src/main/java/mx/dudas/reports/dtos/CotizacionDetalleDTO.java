package mx.dudas.reports.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CotizacionDetalleDTO {
	private Integer idCotizacion;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private BigDecimal subtotal;
    private BigDecimal iva;
    private BigDecimal totalGeneral;
    private String clienteProspecto;
    private String vendedor;
    private String garantia;
    private String detalleCostos;
    private String detalleTabla;
    private String saludo;

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

	public String getGarantia() {
		return garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public String getDetalleCostos() {
		return detalleCostos;
	}

	public void setDetalleCostos(String detalleCostos) {
		this.detalleCostos = detalleCostos;
	}

	public String getDetalleTabla() {
		return detalleTabla;
	}

	public void setDetalleTabla(String detalleTabla) {
		this.detalleTabla = detalleTabla;
	}

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

	public List<DetalleCotizacionDTO> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleCotizacionDTO> detalles) {
		this.detalles = detalles;
	}
    
    
    
}
