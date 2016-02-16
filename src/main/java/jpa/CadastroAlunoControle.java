package jpa;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bancodados.cadastroaluno.dao.AlunoDao;
import bancodados.cadastroaluno.dao.FabricaDeAlunoDao;

@WebServlet(value = "/jpa/CadastroAluno")
public class CadastroAlunoControle extends HttpServlet {

  protected void service(
      HttpServletRequest req,
      HttpServletResponse resp)
      throws ServletException, IOException {

    String paramMatricula = req.getParameter("matricula");
    String matricula = paramMatricula == null ? "" : paramMatricula;
    
    String paramNome = req.getParameter("nome");
    String nome = paramNome == null ? "" : paramNome;

    String paramFone = req.getParameter("fone");
    String fone = paramFone == null ? "" : paramFone;
    
    String paramCpf = req.getParameter("cpf");
    String cpf = paramCpf == null ? "" : paramCpf;

    Aluno aluno = new Aluno();
    aluno.setMatricula(matricula);
    aluno.setNome(nome);
    aluno.setFone(fone);
    aluno.setCpf(cpf);
    
    AlunoBo alunoBo = new AlunoBo();

    alunoBo.incluir(aluno);

    req.setAttribute("aluno", aluno); //Passando um objeto para o JSP.

    List<Aluno> alunos = alunoBo.listar();

    req.setAttribute("alunos", alunos); //Passando uma coleção para o JSP.
    
    //Chamar o JSP apenas para mostrar o resultado.
    req.getRequestDispatcher("CadastroAlunoView.jsp").forward(req, resp);
  }

}
