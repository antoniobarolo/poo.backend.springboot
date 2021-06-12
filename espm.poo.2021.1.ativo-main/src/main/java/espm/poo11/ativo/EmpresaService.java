package espm.poo11.ativo;

import espm.poo11.ativo.common.datatype.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> listAll() {
        return StreamSupport
                .stream(empresaRepository.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .stream().map(EmpresaModel::to)
                .collect(Collectors.toList());
    }

    public Empresa findBy(UUID id) {
        return empresaRepository
                .findById(id.toString())
                .map(EmpresaModel::to)
                .orElse(null);
    }

    public Empresa findByNome(String nome) {
        return empresaRepository
                .findByNome(nome)
                .map(EmpresaModel::to)
                .orElse(null);
    }

}
