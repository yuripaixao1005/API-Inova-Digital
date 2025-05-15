package api.inova.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.inova.digital.model.Pedido;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	//* teste
	Pedido findByNomeCliente(String nomeCliente);
	Pedido findByCodigo(String codigo);

	// Consulta personalizada para filtrar pedidos pelo status
	List<Pedido> findByStatusPedido(String status);
}
