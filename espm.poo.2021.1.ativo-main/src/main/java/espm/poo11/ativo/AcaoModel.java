package espm.poo11.ativo;

import espm.poo11.ativo.common.datatype.Acao;
import espm.poo11.ativo.common.datatype.Empresa;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "acao")
public class AcaoModel {

    @Id
    @Column(name = "id_acao")
    private String idAcao;

    @Column(name = "id_empresa")
    private String idEmpresa;

    @Column(name = "dt_data")
    @Temporal(TemporalType.DATE)
    private Date dtData;

    @Column(name = "vr_valor")
    private BigDecimal vrValor;

    public AcaoModel() {

    }

    public AcaoModel(Acao c) {
        this.idAcao = c.getId();
        this.idEmpresa = c.getEmpresa().getId();
        this.dtData = c.getData();
        this.vrValor = c.getValor();
    }

    public Acao to() {
        Empresa m = new Empresa();
        m.setId(idEmpresa);

        Acao c = new Acao();
        c.setId(idAcao);
        c.setEmpresa(m);
        c.setData(dtData);
        c.setValor(vrValor);
        return c;
    }

}
