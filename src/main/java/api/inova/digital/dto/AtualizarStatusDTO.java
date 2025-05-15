package api.inova.digital.dto;


import javax.validation.constraints.NotNull;

public class AtualizarStatusDTO {

    @NotNull(message = "O status do pedido não pode ser nulo")
    private String statusPedido;

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }
}
