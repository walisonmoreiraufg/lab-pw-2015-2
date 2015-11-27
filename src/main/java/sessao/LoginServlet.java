package sessao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/sessao/login")
public class LoginServlet extends HttpServlet {

  protected void service(
      HttpServletRequest req,
      HttpServletResponse resp)
      throws ServletException, IOException {

    //Referência para a sessão.
    HttpSession sessao = req.getSession();

    String usuario = req.getParameter("usuario");
    String senha = req.getParameter("senha");
    //Usuário válido.
    if (usuario != null && usuario.equals("joao")
        && senha!= null && senha.equals("123")) {
      sessao.setAttribute("usuarioLogado", true);
      resp.sendRedirect("menu");
    } else {
      sessao.setAttribute("usuarioLogado", false);
      req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
  }

}

