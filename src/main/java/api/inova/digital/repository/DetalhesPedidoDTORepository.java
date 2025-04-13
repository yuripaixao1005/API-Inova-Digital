package api.inova.digital.repository;

import api.inova.digital.model.DetalhesPedidoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalhesPedidoDTORepository extends JpaRepository<DetalhesPedidoDTO, Long> {
}
