package br.espm.poo.carteira;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TransacaoAtivoRepository extends CrudRepository<TransacaoAtivoModel, String> {

    @Override
    TransacaoAtivoModel save(TransacaoAtivoModel s);

    @Override
    Optional<TransacaoAtivoModel> findById(String s);

    @Query("SELECT tc from TransacaoAtivoModel tc where tc.idCarteira = :idCarteira order by tc.dtData")
    List<TransacaoAtivoModel> listByCarteira(@Param("idCarteira") String idCarteira);

}
