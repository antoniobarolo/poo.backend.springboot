package br.espm.poo.cambio;

import br.espm.poo.cambio.common.controller.CambioController;
import br.espm.poo.cambio.common.datatype.Cotacao;
import br.espm.poo.cambio.common.datatype.Moeda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class CambioResource implements CambioController {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    private MoedaService moedaService;

    @Autowired
    private CotacaoService cotacaoService;

    @Override
    public List<Moeda> moedas() {
        return moedaService.listAll();
    }

    @Override
    public Moeda moedas(@PathVariable String simbolo) {
        return moedaService.findBySimbolo(simbolo);
    }

    @Override
    public Cotacao cotacao(@PathVariable String id) {
        return cotacaoService.findById(id);
    }

    @Override
    public Cotacao cotacao(String simbolo, String data) {
        try {
            Moeda moeda = moedaService.findBySimbolo(simbolo);
            if (moeda == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, simbolo + " not found");
            }
            System.out.println(data);
            System.out.println(sdf.parse(data));
            return cotacaoService.findBy(moeda.getId(), sdf.parse(data));
        } catch (ParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public List<Cotacao> cotacoes(
            @RequestParam String simbolo,
            @RequestParam String ini,
            @RequestParam String fim) {

        try {
            Moeda moeda = moedaService.findBySimbolo(simbolo);
            if (moeda == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, simbolo + " not found");
            }
            Date dtInicio = ini == null ? null : sdf.parse(ini);
            Date dtTermino = fim == null ? null : sdf.parse(fim);
            return cotacaoService.listBy(moeda.getId(), dtInicio, dtTermino);
        } catch (ParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
