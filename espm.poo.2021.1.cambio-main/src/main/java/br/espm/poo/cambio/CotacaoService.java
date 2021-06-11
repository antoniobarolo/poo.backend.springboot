package br.espm.poo.cambio;

import br.espm.poo.cambio.common.datatype.Cotacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CotacaoService {

    @Autowired
    private MoedaService moedaService;

    @Autowired
    private CotacaoRepository cotacaoRepository;

    public Cotacao findById(String id) {
        return fill(
                cotacaoRepository
                        .findById(id)
                        .map(CotacaoModel::to)
                        .orElse(null)
        );
    }

    public Cotacao findBy(String idMoeda, Date data) {
/*
        List<CotacaoModel> cotacoes = cotacaoRepository.listByMoedaData(idMoeda, data);
        if (cotacoes.size() > 0) {
            CotacaoModel cm = cotacoes.get(0);
            return cm.to();
        } else {
            return null;
        }
*/
        Cotacao cotacao = cotacaoRepository
                .listByMoedaData(idMoeda, data).stream()
                .map(CotacaoModel::to)
                .findFirst()
                .orElse(null);
        // Aqui esta sendo feito um relacionamento
        return fill(cotacao);
    }

    public List<Cotacao> listBy(String idMoeda, Date dtInicio, Date dtFim) {
        return cotacaoRepository
                .listBy(idMoeda, dtInicio, dtFim).stream()
                .map(CotacaoModel::to)
                .collect(Collectors.toList());
    }

    private Cotacao fill(Cotacao c) {
        if (c != null) {
            c.setMoeda(moedaService.findBy(UUID.fromString(c.getMoeda().getId())));
        }
        return c;
    }

}
