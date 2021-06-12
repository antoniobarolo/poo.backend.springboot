package espm.poo11.ativo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AcaoRepository extends CrudRepository<AcaoModel, String> {

    @Override
    Iterable<AcaoModel> findAll();

    @Override
    Optional<AcaoModel> findById(String s);

    @Query("SELECT c from AcaoModel c WHERE c.idEmpresa = :idEmpresa AND c.dtData <= :data ORDER BY c.dtData DESC")
    List<AcaoModel> listByEmpresaData(
            @Param("idEmpresa") String idEmpresa,
            @Param("data") Date data);

    @Query("SELECT c FROM AcaoModel c " +
            "WHERE " +
            "(c.idEmpresa is null or c.idEmpresa = :idEmpresa) AND " +
            "(c.dtData is null or c.dtData >= :dtInicio) AND " +
            "(c.dtData is null or c.dtData <= :dtFim)"
    )
    List<AcaoModel> listBy(
            @Param("idEmpresa") String idEmpresa,
            @Param("dtInicio") Date dtInicio,
            @Param("dtFim") Date dtFim
    );

}
