package api.inova.digital.enums;

public enum StatusPedido {
    ATRASADO("0", "Atrasado"), EM_ANDAMENTO("1", "Produzindo"), CONCLUIDO("2", "Recebido"), ENTREGUE("3", "Finalizado");

    private String codigo;
    private String Descricao;

    StatusPedido(String codigo, String descricao) {
        this.codigo = codigo;
        Descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return Descricao;
    }

    @Override
    public String toString() {
        return this.codigo;
    }
}
