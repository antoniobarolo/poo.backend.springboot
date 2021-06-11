package br.espm.poo.carteira.common.datatype;

import br.espm.poo.cambio.common.datatype.Cotacao;

import java.math.BigDecimal;
import java.util.Date;

public class TransacaoCambio {

    private String id;
    private Carteira carteira;
    private Cotacao cotacao;
    private Date data;
    private BigDecimal quantidade;
    private TransacaoTipo tipo;

    public String getId() {
        return id;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public Cotacao getCotacao() {
        return cotacao;
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

    public void setCotacao(Cotacao cotacao) {
        this.cotacao = cotacao;
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
