package espm.poo11.ativo;

import espm.poo11.ativo.common.datatype.Empresa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class EmpresaModel {

    @Id
    @Column(name = "id_empresa")
    private String idEmpresa;

    
    @Column(name = "tx_nome")
    private String txNome;

    public EmpresaModel() {

    }

    public EmpresaModel(Empresa m) {
        this.idEmpresa = m.getId();
        this.txNome = m.getNome();
    }

    public Empresa to() {
        Empresa m = new Empresa();
        m.setId(idEmpresa);
        m.setNome(txNome);
        return m;
    }

}
