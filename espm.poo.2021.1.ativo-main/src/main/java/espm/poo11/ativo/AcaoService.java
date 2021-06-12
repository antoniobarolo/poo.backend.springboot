package espm.poo11.ativo;

import espm.poo11.ativo.common.datatype.Acao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class AcaoService {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private AcaoRepository acaoRepository;

    public Acao findById(String id) {
        return fill(
                acaoRepository
                        .findById(id)
                        .map(AcaoModel::to)
                        .orElse(null)
        );
    }

    public Acao findBy(String idEmpresa, Date data) {

        Acao acao = acaoRepository
                .listByEmpresaData(idEmpresa, data).stream()
                .map(AcaoModel::to)
                .findFirst()
                .orElse(null);
        // Aqui esta sendo feito um relacionamento
        return fill(acao);
    }

    public List<Acao> listBy(String idEmpresa, Date dtInicio, Date dtFim) {
        return acaoRepository
                .listBy(idEmpresa, dtInicio, dtFim).stream()
                .map(AcaoModel::to)
                .collect(Collectors.toList());
    }

    private Acao fill(Acao c) {
        if (c != null) {
            c.setEmpresa(empresaService.findBy(UUID.fromString(c.getEmpresa().getId())));
        }
        return c;
    }

}
