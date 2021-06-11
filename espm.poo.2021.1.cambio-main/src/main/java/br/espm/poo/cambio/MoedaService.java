package br.espm.poo.cambio;

import br.espm.poo.cambio.common.datatype.Moeda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class MoedaService {

    @Autowired
    private MoedaRepository moedaRepository;

    public List<Moeda> listAll() {
        return StreamSupport
                .stream(moedaRepository.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .stream().map(MoedaModel::to)
                .collect(Collectors.toList());
    }

    public Moeda findBy(UUID id) {
        return moedaRepository
                .findById(id.toString())
                .map(MoedaModel::to)
                .orElse(null);
    }

    public Moeda findBySimbolo(String simbolo) {
        return moedaRepository
                .findBySimbolo(simbolo)
                .map(MoedaModel::to)
                .orElse(null);
    }

}
