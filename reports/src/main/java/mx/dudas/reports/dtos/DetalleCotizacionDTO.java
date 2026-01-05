package mx.dudas.reports.dtos;

import java.math.BigDecimal;


public class DetalleCotizacionDTO {

    private Integer idDetalleCotizacion;
    private Integer idCotizacion;
    private String descripcion;
    private BigDecimal precioUnitario;
    private BigDecimal importe;
    private Integer cantidad;
	public Integer getIdDetalleCotizacion() {
		return idDetalleCotizacion;
	}
	public void setIdDetalleCotizacion(Integer idDetalleCotizacion) {
		this.idDetalleCotizacion = idDetalleCotizacion;
	}
	public Integer getIdCotizacion() {
		return idCotizacion;
	}
	public void setIdCotizacion(Integer idCotizacion) {
		this.idCotizacion = idCotizacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
    
	
}

