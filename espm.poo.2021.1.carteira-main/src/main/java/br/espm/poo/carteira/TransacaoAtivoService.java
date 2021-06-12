package br.espm.poo.carteira;

import br.espm.poo.ativo.common.controller.AtivoController;
import br.espm.poo.ativo.common.datatype.Acao;
import br.espm.poo.ativo.common.datatype.Empresa;
import br.espm.poo.carteira.common.datatype.Carteira;
import br.espm.poo.carteira.common.datatype.TransacaoBean;
import br.espm.poo.carteira.common.datatype.TransacaoAtivo;
import br.espm.poo.carteira.common.datatype.TransacaoTipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class TransacaoAtivoService {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    private AtivoController ativoController;

    @Autowired
    private CarteiraService carteiraService;

    @Autowired
    private TransacaoAtivoRepository transacaoAtivoRepository;

    public List<TransacaoAtivo> listByCarteira(String idCarteira) {
        List<TransacaoAtivo> l = transacaoAtivoRepository
                .listByCarteira(idCarteira).stream()
                .map(TransacaoAtivoModel::to)
                .collect(Collectors.toList());
        return l;
    }

    public TransacaoAtivo comprar(String idCarteira, TransacaoBean bean) {
        Carteira c = carteiraService.findBy(idCarteira);
        if (c == null) {
            throw new RuntimeException("Carteira nao existe: " + idCarteira);
        }

        Date agora = new Date();

        Empresa empresa = ativoController.empresas(bean.getNome());
        if (empresa == null) {
            throw new RuntimeException("Empresa nao existe: " + bean.getNome());
        }

        Acao acao = ativoController.acao(empresa.getNome(), sdf.format(agora));
        if (acao == null) {
            throw new RuntimeException("Acao nao existe: " + sdf.format(agora));
        }

        TransacaoAtivo tc = new TransacaoAtivo();
        tc.setId(UUID.randomUUID().toString());
        tc.setCarteira(c);
        tc.setAcao(acao);
        tc.setTipo(TransacaoTipo.COMPRA);
        tc.setQuantidade(bean.getQtd());
        tc.setData(agora);

        return transacaoAtivoRepository.save(new TransacaoAtivoModel(tc)).to();
    }

    public TransacaoAtivo vender(String idCarteira, TransacaoBean bean) {
        Carteira c = carteiraService.findBy(idCarteira);
        if (c == null) {
            throw new RuntimeException("Carteira nao existe: " + idCarteira);
        }

        Date agora = new Date();

        Empresa empresa = ativoController.empresas(bean.getNome());
        if (empresa == null) {
            throw new RuntimeException("Empresa nao existe: " + bean.getNome());
        }

        Acao acao = ativoController.acao(empresa.getNome(), sdf.format(agora));
        if (acao == null) {
            throw new RuntimeException("Ação nao existe: " + sdf.format(agora));
        }

        if (BigDecimal.ZERO.compareTo(bean.getLimite()) <= 0
                && bean.getLimite().compareTo(acao.getValor()) > 0) {
            throw new RuntimeException("Ação limite, atual: " + acao.getValor());
        }

        TransacaoAtivo tc = new TransacaoAtivo();
        tc.setId(UUID.randomUUID().toString());
        tc.setCarteira(c);
        tc.setAcao(acao);
        tc.setTipo(TransacaoTipo.VENDA);
        tc.setQuantidade(bean.getQtd());
        tc.setData(agora);

        return transacaoAtivoRepository.save(new TransacaoAtivoModel(tc)).to();
    }

}
