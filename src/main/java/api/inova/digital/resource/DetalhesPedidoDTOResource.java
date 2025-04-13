package api.inova.digital.resource;

import api.inova.digital.model.DetalhesPedidoDTO;
import api.inova.digital.repository.DetalhesPedidoDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalhes-pedido")
@CrossOrigin(origins = "*") // Permite requisições de qualquer origem (ex: frontend separado)
public class DetalhesPedidoDTOResource {

    @Autowired
    private DetalhesPedidoDTORepository repository;

    // POST - criar novo
    @PostMapping
    public DetalhesPedidoDTO criarDetalhe(@RequestBody DetalhesPedidoDTO detalhes) {
        return repository.save(detalhes);
    }

    // GET - listar todos
    @GetMapping
    public List<DetalhesPedidoDTO> listarTodos() {
        return repository.findAll();
    }

    // GET - buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<DetalhesPedidoDTO> buscarPorId(@PathVariable Long id) {
        Optional<DetalhesPedidoDTO> resultado = repository.findById(id);
        return resultado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
