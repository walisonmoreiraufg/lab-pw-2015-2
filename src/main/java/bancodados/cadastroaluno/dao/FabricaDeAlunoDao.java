package bancodados.cadastroaluno.dao;

public class FabricaDeAlunoDao {

  public static AlunoDao novo(String tipoDeAluno) {
    if (tipoDeAluno.equals("ead")) {
      return new AlunoMongoDao();
    } else if (tipoDeAluno.equals("empresarial")) {
      return new AlunoOracleDao();
    } else {
      return new AlunoDerbyDao();
    }
  }

}
