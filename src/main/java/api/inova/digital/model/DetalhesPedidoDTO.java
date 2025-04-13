package api.inova.digital.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_detalhe_pedido")
public class DetalhesPedidoDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull
    @Size(min = 3, max = 100, message = "O nome deve conter pelo menos 3 caracteres e no máximo 100 caracteres.")
    private String nomeCliente;

    private String status;

    private String entregaPedido;

    // Getters e setters

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEntregaPedido() {
        return entregaPedido;
    }

    public void setEntregaPedido(String entregaPedido) {
        this.entregaPedido = entregaPedido;
    }
}
