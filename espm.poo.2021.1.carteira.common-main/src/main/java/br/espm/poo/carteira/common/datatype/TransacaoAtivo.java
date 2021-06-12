package br.espm.poo.carteira.common.datatype;

import java.math.BigDecimal;
import java.util.Date;

import espm.poo11.ativo.common.datatype.Acao;

public class TransacaoAtivo {

    private String id;
    private Carteira carteira;
    private Acao acao;
    private Date data;
    private BigDecimal quantidade;
    private TransacaoTipo tipo;

    public String getId() {
        return id;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public Acao getAcao() {
        return acao;
    }

    public Date getData() {
        return data;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public TransacaoTipo getTipo() {
        return tipo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public void setTipo(TransacaoTipo tipo) {
        this.tipo = tipo;
    }

}
