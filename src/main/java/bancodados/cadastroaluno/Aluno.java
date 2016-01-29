package bancodados.cadastroaluno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Aluno {
  private String matricula;
  public String getMatricula() {return matricula;}
  public void setMatricula(String matricula) {this.matricula = matricula;}
  
  private String nome;
  public String getNome() {return nome;}
  public void setNome(String nome) {this.nome = nome;}
  
  private String fone;
  public String getFone() {return fone;}
  public void setFone(String fone) {this.fone = fone;}
  
  private String cpf;
  public String getCpf() {return cpf;}
  public void setCpf(String cpf) {this.cpf = cpf;}

  public void incluir() {
    try {
      //Obtém a conexão.
      String url = "jdbc:derby:C:\\banco-de-teste;create=true";
      Connection conn = DriverManager.getConnection(url);
      //Cria a sentença SQL.
      String sql = "insert into aluno (matricula, nome, fone, cpf) values (?, ?, ?, ?)";
      //Obtém referência para uma sentença SQL.
      PreparedStatement prepareStatement = conn.prepareStatement(sql);
      prepareStatement.setString(1, matricula);
      prepareStatement.setString(2, nome);
      prepareStatement.setString(3, fone);
      prepareStatement.setString(4, cpf);
      //Executa a instrução SQL.
      prepareStatement.executeUpdate();
      //Fecha a sentença.
      prepareStatement.close();
      //Fecha a conexão.
      conn.close();
    } catch(Throwable e) {
      //Para repassar a exceção para o container tratar.
      throw new RuntimeException(e);
    }
  }
  
  public static List<Aluno> listar() {
    List<Aluno> alunos = new ArrayList<Aluno>();
    try {
      
      //Obtém a conexão.
      String url = "jdbc:derby:C:\\banco-de-teste;create=true";
      Connection conn = DriverManager.getConnection(url);
      //Cria a sentença SQL.
      String sql = "select * from aluno order by matricula";
      //Obtém referência para uma sentença SQL.
      PreparedStatement prepareStatement = conn.prepareStatement(sql);
      //Executa a instrução SQL.
      ResultSet rs = prepareStatement.executeQuery();
      while (rs.next()) {

        Aluno a = new Aluno();
        a.setMatricula(rs.getString("matricula"));
        a.setNome(rs.getString("nome"));
        a.setFone(rs.getString("fone"));
        a.setCpf(rs.getString("cpf"));

        alunos.add(a);
      }
      //Fecha o ResultSet.
      rs.close();
      //Fecha a sentença.
      prepareStatement.close();
      //Fecha a conexão.
      conn.close();
    } catch (Throwable e) {
      //Para repassar a exceção para o container tratar.
      throw new RuntimeException(e);
    }

    return alunos;
  }
}
