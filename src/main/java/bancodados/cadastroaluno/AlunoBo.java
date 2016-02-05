package bancodados.cadastroaluno;

import java.util.List;

import bancodados.cadastroaluno.dao.AlunoDao;
import bancodados.cadastroaluno.dao.FabricaDeAlunoDao;

//Business Object.
public class AlunoBo {
  
  AlunoDao alunoDao;
  
  public AlunoBo(String tipoDeAluno) {
    alunoDao = FabricaDeAlunoDao.novo(tipoDeAluno);
  }

  public void incluir(Aluno aluno) {
    if (!aluno.getMatricula().equals("")) {
      alunoDao.incluir(aluno);
    }
  }

  public List<Aluno> listar() {
    return alunoDao.listar();
  }

}
