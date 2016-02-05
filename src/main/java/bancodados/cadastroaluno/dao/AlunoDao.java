package bancodados.cadastroaluno.dao;

import java.util.List;

import bancodados.cadastroaluno.Aluno;

public interface AlunoDao {

  public void incluir(Aluno aluno);

  public List<Aluno> listar();
}
