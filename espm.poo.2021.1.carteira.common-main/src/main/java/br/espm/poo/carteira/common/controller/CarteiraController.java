package br.espm.poo.carteira.common.controller;

import br.espm.poo.carteira.common.datatype.Carteira;
import br.espm.poo.carteira.common.datatype.TransacaoBean;
import br.espm.poo.carteira.common.datatype.TransacaoCambio;
import br.espm.poo.carteira.common.datatype.TransacaoAtivo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("carteira-service")
public interface CarteiraController {

    @GetMapping("carteiras")
    List<Carteira> carteiras();

    @GetMapping("carteiras/{id}")
    Carteira carteira(@PathVariable String id);

    @PostMapping("carteiras")
    Carteira create(@RequestBody Carteira carteira);

    @PostMapping("carteiras/{idCarteira}/cambio/comprar")
    TransacaoCambio cambioComprar(
            @PathVariable String idCarteira,
            @RequestBody TransacaoBean bean
    );

    @PostMapping("carteiras/{idCarteira}/cambio/vender")
    TransacaoCambio cambioVender(
            @PathVariable String idCarteira,
            @RequestBody TransacaoBean bean
    );

    @PostMapping("carteiras/{idCarteira}/ativo/comprar")
    TransacaoAtivo ativoComprar(
            @PathVariable String idCarteira,
            @RequestBody TransacaoBean bean
    );

    @PostMapping("carteiras/{idCarteira}/ativo/vender")
    TransacaoAtivo ativoVender(
            @PathVariable String idCarteira,
            @RequestBody TransacaoBean bean
    );

}
