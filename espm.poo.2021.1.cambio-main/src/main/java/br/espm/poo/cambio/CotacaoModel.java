package br.espm.poo.cambio;

import br.espm.poo.cambio.common.datatype.Cotacao;
import br.espm.poo.cambio.common.datatype.Moeda;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "cotacao")
public class CotacaoModel {

    @Id
    @Column(name = "id_cotacao")
    private String idCotacao;

    @Column(name = "id_moeda")
    private String idMoeda;

    @Column(name = "dt_data")
    @Temporal(TemporalType.DATE)
    private Date dtData;

    @Column(name = "vr_valor")
    private BigDecimal vrValor;

    public CotacaoModel() {

    }

    public CotacaoModel(Cotacao c) {
        this.idCotacao = c.getId();
        this.idMoeda = c.getMoeda().getId();
        this.dtData = c.getData();
        this.vrValor = c.getValor();
    }

    public Cotacao to() {
        Moeda m = new Moeda();
        m.setId(idMoeda);

        Cotacao c = new Cotacao();
        c.setId(idCotacao);
        c.setMoeda(m);
        c.setData(dtData);
        c.setValor(vrValor);
        return c;
    }

}
