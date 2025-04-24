package api.inova.digital.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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
	private String status;




	private String valorPedido;
	


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

	public String getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(String valorPedido) {
		this.valorPedido = valorPedido;
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
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
