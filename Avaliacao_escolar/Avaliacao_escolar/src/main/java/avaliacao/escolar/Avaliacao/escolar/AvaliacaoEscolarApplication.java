package avaliacao.escolar.Avaliacao.escolar;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import avaliacao.escolar.Avaliacao.escolar.orm.Aluno;
import avaliacao.escolar.Avaliacao.escolar.orm.avaliacao;
import avaliacao.escolar.Avaliacao.escolar.repository.AlunoRepository;
import avaliacao.escolar.Avaliacao.escolar.repository.AvaliacaoRepository;


@SpringBootApplication
public class AvaliacaoEscolarApplication implements CommandLineRunner {

	private final AlunoRepository alRepository;
	private final AvaliacaoRepository avRepository;
	

	public AvaliacaoEscolarApplication(AlunoRepository alRepository, AvaliacaoRepository avRepository) {
		this.alRepository = alRepository;
		this.avRepository = avRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AvaliacaoEscolarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		
		inserirTeste();

		calcularnotas();
	}

	public void inserirTeste() {
		inseriraluno("Pedro", 1);

		inseriraval(1, 1, 1, 5, 8, 3, 6, 10);
		inseriraval(2, 1, 2, 6, 7, 4, 7, 7);
		inseriraval(3, 1, 3, 10, 6, 8, 8, 6);
		inseriraval(4, 1, 4, 1, 5, 10, 9, 10);

		inseriraluno("Maria", 2);
		inseriraval(5, 2, 1, 15, 6, 8, 9, 10);
		inseriraval(6, 2, 2, 10, 6, 7, 8, 10);
		inseriraval(7, 2, 3, 5, 8, 9, 9, 9);
		inseriraval(8, 2, 4, 25, 2, 8, 8, 10);

		inseriraluno("João", 3);
		inseriraval(9, 3, 1, 0, 4, 6, 4, 4);
		inseriraval(10, 3, 2, 0, 6, 3, 5, 6);
		inseriraval(11, 3, 3, 1, 5, 4, 6, 4);
		inseriraval(12, 3, 4, 3, 3, 5, 3, 5);
	}

	public void inseriraluno(String nome, Integer mat) {

		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setMatricula(mat);

		alRepository.save(aluno);
	}

	public void inseriraval(Integer id, Integer mat, Integer bimestre, Integer faltas, float part, float prova,
			float tarefa, float trabalho) {
		avaliacao aval = new avaliacao();
		aval.setBimestre(bimestre);
		aval.setFalta(faltas);
		aval.setPart(part);
		aval.setProva(prova);
		aval.setTarefa(tarefa);
		aval.setTrabalho(trabalho);
		aval.setMatricula(mat);
		aval.setId(id);
		avRepository.save(aval);
	}

	public void calcularnotas() {

		List<Aluno> alunos = alRepository.findAll();
		float[] notas_bi = { 0, 0, 0, 0 };
		Aluno al = new Aluno();
		int[] freq = { 0, 0, 0, 0 };
		float notaFinal;
		int freqFinal;

		for (int i = 0; i < alunos.size(); i++) {

			al = alunos.get(i);
			List<avaliacao> avBi = avRepository.findByMatricula(al.getMatricula());
			for (int j = 0; j < 4; j++) {

				avaliacao av = avBi.get(j);
				notas_bi[j] = (float) (((av.getPart() * 1.5) + (av.getTarefa() * 2.5) + (av.getProva() * 3)
						+ (av.getTrabalho() * 3)) / 10);
				freq[j] = 100 - ((av.getFalta() * 100) / 40);

			}
			al.setNota1b(notas_bi[0]);
			al.setNota2b(notas_bi[1]);
			al.setNota3b(notas_bi[2]);
			al.setNota4b(notas_bi[3]);
			notaFinal = (notas_bi[0] + notas_bi[1] + notas_bi[2] + notas_bi[3]) / 4;
			freqFinal = (freq[0] + freq[1] + freq[2] + freq[3]) / 4;
			al.setFreq(freqFinal);
			if (freqFinal >= 75 && notaFinal >= 6) {
				al.setSituacao("APROVADO");
			} else {
				if (freqFinal < 75 || notaFinal < 5) {
					al.setSituacao("REPROVADO");
				} else {
					al.setSituacao("RECUPERAÇÃO");
				}
			}
			alRepository.save(al);
		}

	}

}
