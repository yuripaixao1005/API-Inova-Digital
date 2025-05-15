package api.inova.digital.resource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import api.inova.digital.dto.AtualizarStatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import api.inova.digital.model.Pedido;
import api.inova.digital.repository.PedidoRepository;


@RestController
@RequestMapping("/inovadigital")
public class PedidoResource {

	@Autowired
	private PedidoRepository pedidoRepository;



	@GetMapping("/pedidos")
	public List<Pedido> getPedidos(@RequestParam(value = "status", required = false) String status) {
		if (status != null && !status.isEmpty()) {
			// Se o status for informado, filtra os pedidos pelo status
			return pedidoRepository.findByStatusPedido(status);
		}
		// Caso contrário, retorna todos os pedidos
		return pedidoRepository.findAll();
	}
	@GetMapping("/pedidos/notificacoes")
	public List<Pedido> getPedidosParaNotificacao() {
		System.out.println("Recebendo requisição para notificações de pedidos");

		List<Pedido> todosPedidos = pedidoRepository.findAll();

		LocalDate hoje = LocalDate.now();
		LocalDate amanha = hoje.plusDays(1);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		return todosPedidos.stream()
				.filter(p -> {
					try {
						// Exclui pedidos com status "Finalizado"
						if (p.getStatusPedido().equalsIgnoreCase("Finalizado")) return false;

						// Converte a data de entrega
						LocalDate dataEntrega = LocalDate.parse(p.getEntregaPedido(), formatter);

						// Filtra pedidos com data de entrega hoje, amanhã ou atrasados
						if (dataEntrega.equals(hoje) || dataEntrega.equals(amanha) || dataEntrega.isBefore(hoje)) {
							return true; // Pedido precisa ser notificado
						} else {
							return false; // Pedido não precisa ser notificado
						}

					} catch (Exception e) {
						// Se der erro ao converter a data, ignora esse pedido
						return false;
					}
				})
				.collect(Collectors.toList());
	}

	@GetMapping("/pedidos/{codigo}")
	public ResponseEntity<?> getPedido(@PathVariable Long codigo) {
		Optional<?> pedidoProcurado = pedidoRepository.findById(codigo);
		return pedidoProcurado.isPresent() ?
				ResponseEntity.ok(pedidoProcurado.get()) :
				ResponseEntity.notFound().build();
	}

	@PostMapping("/pedidos")
	@ResponseStatus(HttpStatus.CREATED)
	public Pedido gravar(@Valid @RequestBody Pedido pedido) {
		return pedidoRepository.save(pedido);
	}



	@DeleteMapping("/pedidos/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long codigo) {
		pedidoRepository.deleteById(codigo);
	}

	@PutMapping("/pedidos")
	public void atualizar(@Valid @RequestBody Pedido pedido) {
		pedidoRepository.save(pedido);
	}

	@PutMapping("/pedidos/{id}")
	public ResponseEntity<String> atualizar(@PathVariable Long id, @Valid @RequestBody AtualizarStatusDTO dto) {
		Optional<Pedido> pedidoExistente = pedidoRepository.findById(id);

		if (pedidoExistente.isPresent()) {
			Pedido pedidoAtualizado = pedidoExistente.get();

			pedidoAtualizado.setStatusPedido(dto.getStatusPedido());

			pedidoRepository.save(pedidoAtualizado);

			return ResponseEntity.ok("Pedido atualizado com sucesso");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
		}
	}
	}






