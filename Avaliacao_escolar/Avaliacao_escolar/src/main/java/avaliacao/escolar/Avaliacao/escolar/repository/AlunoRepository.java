package avaliacao.escolar.Avaliacao.escolar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import avaliacao.escolar.Avaliacao.escolar.orm.Aluno;
import avaliacao.escolar.Avaliacao.escolar.orm.avaliacao;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Integer> {
	List<Aluno> findByMatricula(Integer Matricula);
	List<Aluno> findAll();
	
}
