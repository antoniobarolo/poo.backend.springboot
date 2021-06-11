package espm.poo11.ativo.common.datatype;

import java.math.BigDecimal;
import java.util.Date;

public class Acao {

    private String id;
    private Empresa empresa;
    private BigDecimal valor;
    private Date data;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Empresa getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }

}
