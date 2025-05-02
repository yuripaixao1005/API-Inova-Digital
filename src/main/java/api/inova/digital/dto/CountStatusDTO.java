package api.inova.digital.dto;

import api.inova.digital.enums.StatusPedido;

public class CountStatusDTO {

    private String descricao;
    private Long quantidade;

    public CountStatusDTO(StatusPedido descricao, Long quantidade) {
        this.descricao = descricao.getDescricao();
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
