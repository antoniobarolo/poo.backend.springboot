package br.espm.poo.cambio;

import br.espm.poo.cambio.common.datatype.Moeda;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "moeda")
public class MoedaModel {

    @Id
    @Column(name = "id_moeda")
    private String idMoeda;

    @Column(name = "tx_nome")
    private String txNome;
    @Column(name = "tx_simbolo")
    private String txSimbolo;

    public MoedaModel() {

    }

    public MoedaModel(Moeda m) {
        this.idMoeda = m.getId();
        this.txNome = m.getNome();
        this.txSimbolo = m.getSimbolo();
    }

    public Moeda to() {
        Moeda m = new Moeda();
        m.setId(idMoeda);
        m.setNome(txNome);
        m.setSimbolo(txSimbolo);
        return m;
    }

}
