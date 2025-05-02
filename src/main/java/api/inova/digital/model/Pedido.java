package api.inova.digital.model;

import api.inova.digital.enums.StatusPedido;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotNull
	@Size(min = 3, max = 100, message = "O nome deve conter pelo menos 3 caracteres e no máximo 100 caracteres.")
	private String nomeCliente;
	
	private String tipoServico;
	private String descricaoPedido;
	private String quantidadePedido;
	private String entregaPedido;
	private StatusPedido status;
	private String valorPedido;
	private LocalDate prazoEntrega;

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

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public String getDescricaoPedido() {
		return descricaoPedido;
	}

	public void setDescricaoPedido(String descricaoPedido) {
		this.descricaoPedido = descricaoPedido;
	}

	public String getQuantidadePedido() {
		return quantidadePedido;
	}

	public void setQuantidadePedido(String quantidadePedido) {
		this.quantidadePedido = quantidadePedido;
	}

	public String getEntregaPedido() {
		return entregaPedido;
	}

	public void setEntregaPedido(String entregaPedido) {
		this.entregaPedido = entregaPedido;
	}

	@Enumerated(EnumType.STRING)
	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public String getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(String valorPedido) {
		this.valorPedido = valorPedido;
	}

	public LocalDate getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(LocalDate prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	@Override
	public String toString() {
		return "Pedido{" +
				"codigo=" + codigo +
				", nomeCliente='" + nomeCliente + '\'' +
				", tipoServico='" + tipoServico + '\'' +
				", descricaoPedido='" + descricaoPedido + '\'' +
				", quantidadePedido='" + quantidadePedido + '\'' +
				", entregaPedido='" + entregaPedido + '\'' +
				", valorPedido='" + valorPedido + '\'' +
				'}';
	}
	public Pedido(LocalDate prazoEntrega, Long codigo) {
		this.prazoEntrega = prazoEntrega;
		this.codigo = codigo;
	}
}
