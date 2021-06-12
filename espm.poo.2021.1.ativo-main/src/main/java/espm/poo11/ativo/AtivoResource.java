package espm.poo11.ativo;

import espm.poo11.ativo.common.controller.AtivoController;
import espm.poo11.ativo.common.datatype.Acao;
import espm.poo11.ativo.common.datatype.Empresa;
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
public class AtivoResource implements AtivoController {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private AcaoService acaoService;

    @Override
    public List<Empresa> empresas() {
        return empresaService.listAll();
    }

    @Override
    public Empresa empresas(@PathVariable String nome) {
        return empresaService.findByNome(nome);
    }

    @Override
    public Acao acao(@PathVariable String id) {
        return acaoService.findById(id);
    }

    @Override
    public Acao acao(String nome, String data) {
        try {
            Empresa empresa = empresaService.findByNome(nome);
            if (empresa == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, nome + " not found");
            }
            System.out.println(data);
            System.out.println(sdf.parse(data));
            return acaoService.findBy(empresa.getId(), sdf.parse(data));
        } catch (ParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public List<Acao> acoes(
            @RequestParam String nome,
            @RequestParam String ini,
            @RequestParam String fim) {

        try {
            Empresa empresa = empresaService.findByNome(nome);
            if (empresa == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, nome + " not found");
            }
            Date dtInicio = ini == null ? null : sdf.parse(ini);
            Date dtTermino = fim == null ? null : sdf.parse(fim);
            return acaoService.listBy(empresa.getId(), dtInicio, dtTermino);
        } catch (ParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
