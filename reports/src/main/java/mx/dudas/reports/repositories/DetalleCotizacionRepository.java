package mx.dudas.reports.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.dudas.reports.entities.DetalleCotizacion;

public interface DetalleCotizacionRepository extends JpaRepository<DetalleCotizacion, Integer> {

	List<DetalleCotizacion> findByCotizacion_IdCotizacion(Integer idCotizacion);
}
