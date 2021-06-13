package br.espm.poo.carteira;

import espm.poo11.ativo.common.datatype.Acao;
import br.espm.poo.carteira.common.datatype.Carteira;
import br.espm.poo.carteira.common.datatype.TransacaoAtivo;
import br.espm.poo.carteira.common.datatype.TransacaoTipo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transacaoativo")
public class TransacaoAtivoModel {

    @Id
    @Column(name = "id_transacaoativo")
    private String idTransacaoAtivo;

    @Column(name = "id_carteira")
    private String idCarteira;

    @Column(name = "id_acao")
    private String idAcao;

    @Column(name = "dt_data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtData;

    @Column(name = "nr_qtd")
    private BigDecimal nrQtd;

    @Column(name = "nr_tipo")
    private Integer nrTipo;

    public TransacaoAtivoModel() {

    }

    public TransacaoAtivoModel(TransacaoAtivo tc) {
        this.idTransacaoAtivo = tc.getId();
        this.dtData = tc.getData();
        this.idCarteira = tc.getCarteira().getId();
        this.idAcao = tc.getAcao().getId();
        this.nrTipo = tc.getTipo().equals(TransacaoTipo.VENDA) ? 1 : 2;
        this.nrQtd = tc.getQuantidade();
    }

    public TransacaoAtivo to() {
        Carteira carteira = new Carteira();
        carteira.setId(idCarteira);

        Acao acao = new Acao();
        acao.setId(idAcao);

        TransacaoAtivo tc = new TransacaoAtivo();
        tc.setId(idTransacaoAtivo);
        tc.setData(dtData);
        tc.setQuantidade(nrQtd);
        tc.setTipo(1 == nrTipo ? TransacaoTipo.VENDA : TransacaoTipo.COMPRA);
        tc.setCarteira(carteira);
        tc.setAcao(acao);
        return tc;
    }

}
