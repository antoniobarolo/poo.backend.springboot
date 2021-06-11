package espm.poo11.ativo.common.controller;

import espm.poo11.ativo.common.datatype.Acao;
import espm.poo11.ativo.common.datatype.Empresa;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("acao-service")
public interface AtivoController {

    @GetMapping("/empresas")
    List<Empresa> empresas();

    @GetMapping("/empresas/{nome}")
    Empresa empresas(@PathVariable String nome);

    @GetMapping("/acoes/{id}")
    Acao acao(@PathVariable String id);

    @GetMapping("/acoes/{nome}/{data}")
    Acao acao(
            @PathVariable String nome,
            @PathVariable String data
    );

    @GetMapping("/acoes")
    List<Acao> acoes(
            @RequestParam String nome,
            @RequestParam String ini,
            @RequestParam String fim
    );

}
