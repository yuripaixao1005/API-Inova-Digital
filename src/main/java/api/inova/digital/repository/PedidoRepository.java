package api.inova.digital.repository;

import api.inova.digital.dto.CountStatusDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import api.inova.digital.model.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	//* teste
	Pedido findByNomeCliente(String nomeCliente);
	Pedido findByCodigo(String codigo);

	@Query("SELECT new api.inova.digital.model.Pedido(p.prazoEntrega, p.codigo) FROM Pedido p WHERE prazo_entrega = :prazoEntrega")
	List<Pedido> finByData(@Param("prazoEntrega") LocalDate prazoEntrega);

	Pedido findByStatus(String status);

	@Query("SELECT new api.inova.digital.dto.CountStatusDTO(p.status, COUNT(p)) FROM Pedido p GROUP BY p.status")
	List<CountStatusDTO> countByStatus();
}
