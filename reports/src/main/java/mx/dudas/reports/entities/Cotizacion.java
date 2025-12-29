package mx.dudas.reports.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cotizacion", schema = "general")
public class Cotizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cotizacion")
    private Integer idCotizacion;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision;

    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

    private BigDecimal subtotal;
    private BigDecimal iva;

    @Column(name = "total_general")
    private BigDecimal totalGeneral;

    private String garantia;
    private String vendedor;

    @Column(name = "detalle_equipos")
    private String detalleEquipos;

    @Column(name = "detalle_costos")
    private String detalleCostos;

    @Column(name = "cliente_prospecto")
    private String clienteProspecto;

    private String saludo;

    @Column(name = "detalle_tabla")
    private String detalleTabla;

    // Relación
    @OneToMany(mappedBy = "cotizacion", cascade = CascadeType.ALL)
    private List<DetalleCotizacion> detalles;

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

	public String getGarantia() {
		return garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getDetalleEquipos() {
		return detalleEquipos;
	}

	public void setDetalleEquipos(String detalleEquipos) {
		this.detalleEquipos = detalleEquipos;
	}

	public String getDetalleCostos() {
		return detalleCostos;
	}

	public void setDetalleCostos(String detalleCostos) {
		this.detalleCostos = detalleCostos;
	}

	public String getClienteProspecto() {
		return clienteProspecto;
	}

	public void setClienteProspecto(String clienteProspecto) {
		this.clienteProspecto = clienteProspecto;
	}

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

	public String getDetalleTabla() {
		return detalleTabla;
	}

	public void setDetalleTabla(String detalleTabla) {
		this.detalleTabla = detalleTabla;
	}

	public List<DetalleCotizacion> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleCotizacion> detalles) {
		this.detalles = detalles;
	}
    
    
    
}