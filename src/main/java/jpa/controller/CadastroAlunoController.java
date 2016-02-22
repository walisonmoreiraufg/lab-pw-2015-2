package jpa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.model.Aluno;
import jpa.model.AlunoBo;
import jpa.model.Pessoa;

@WebServlet(value = "/jpa/CadastroAluno")
public class CadastroAlunoController extends HttpServlet {

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

    String paramAtivo = req.getParameter("ativo");
    String ativo = paramAtivo == null ? "" : paramAtivo;

    Aluno aluno = new Aluno();
    aluno.setMatricula(matricula);
    aluno.setNome(nome);
    aluno.setFone(fone);
    aluno.setCpf(cpf);
    aluno.setAtivo(ativo);
    
    String paramCpfMae = req.getParameter("cpfMae");
    String cpfMae = paramCpfMae == null ? "" : paramCpfMae;
    
    String paramNomeMae = req.getParameter("nomeMae");
    String nomeMae = paramNomeMae == null ? "" : paramNomeMae;

    Pessoa mae = new Pessoa();
    mae.setCpf(cpfMae);
    mae.setNome(nomeMae);

    aluno.setMae(mae);

    String paramCpfPai = req.getParameter("cpfPai");
    String cpfPai = paramCpfPai == null ? "" : paramCpfPai;
    
    String paramNomePai = req.getParameter("nomePai");
    String nomePai = paramNomePai == null ? "" : paramNomePai;

    Pessoa pai = new Pessoa();
    pai.setCpf(cpfPai);
    pai.setNome(nomePai);

    aluno.setPai(pai);

    AlunoBo alunoBo = new AlunoBo();

    alunoBo.incluir(aluno);

    req.setAttribute("aluno", aluno); //Passando um objeto para o JSP.

    List<Aluno> alunos = alunoBo.listar();

    req.setAttribute("alunos", alunos); //Passando uma coleção para o JSP.
    
    //Chamar o JSP apenas para mostrar o resultado.
    req.getRequestDispatcher("CadastroAlunoView.jsp").forward(req, resp);
  }

}
