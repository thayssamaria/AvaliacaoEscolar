package avaliacao.escolar.Avaliacao.escolar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import avaliacao.escolar.Avaliacao.escolar.orm.avaliacao;


@Repository
public interface AvaliacaoRepository extends CrudRepository <avaliacao, Integer>{
	List<avaliacao> findByMatriculaAndBimestre(int  matricula, int bimestre);
	List<avaliacao> findByMatricula(int  matricula);
	

}
