package api.inova.digital.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import api.inova.digital.model.Pedido;
import api.inova.digital.repository.PedidoRepository;
import api.inova.digital.upload.FileUpload;
import api.inova.digital.upload.FileUploadUrl;
import api.inova.digital.upload.FireBaseStorageService;

@RestController
@RequestMapping("/inovadigital")
public class PedidoResource {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private FireBaseStorageService firebase;
	
	@GetMapping("/pedidos")
	public List<Pedido> getPedidos(){
		return pedidoRepository.findAll();
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
	
}
