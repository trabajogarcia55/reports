package mx.dudas.reports.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.dudas.reports.entities.Cotizacion;


@Repository
public interface CotizacionRepository extends JpaRepository<Cotizacion, Integer> {
	
}
