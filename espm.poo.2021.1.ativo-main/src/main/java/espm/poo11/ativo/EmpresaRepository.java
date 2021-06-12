package espm.poo11.ativo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmpresaRepository extends CrudRepository<EmpresaModel, String> {

    @Override
    Iterable<EmpresaModel> findAll();

    @Override
    Optional<EmpresaModel> findById(String s);

    @Query("SELECT m from EmpresaModel m WHERE UPPER(m.txNome) = UPPER(:nome)")
    Optional<EmpresaModel> findByNome(@Param("nome") String nome);

}
