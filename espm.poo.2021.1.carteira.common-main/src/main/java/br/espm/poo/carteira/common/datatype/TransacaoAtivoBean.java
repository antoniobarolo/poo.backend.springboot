package br.espm.poo.carteira.common.datatype;

import java.math.BigDecimal;

public class TransacaoAtivoBean {

    private String nome;
    private BigDecimal qtd;
    private BigDecimal limite;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getQtd() {
        return qtd;
    }

    public void setQtd(BigDecimal qtd) {
        this.qtd = qtd;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

}
