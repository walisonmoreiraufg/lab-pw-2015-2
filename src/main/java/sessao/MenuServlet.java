package sessao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/sessao/menu")
public class MenuServlet extends HttpServlet {

  protected void service(
      HttpServletRequest req,
      HttpServletResponse resp)
      throws ServletException, IOException {

    //Referência para a sessão.
    HttpSession sessao = req.getSession();

    //Obtém referência para o atributo "usuarioLogado".
    Boolean usuarioLogado = (Boolean) sessao.getAttribute("usuarioLogado");
    
    if (usuarioLogado == null || usuarioLogado == false) {
      req.getRequestDispatcher("login.jsp").forward(req, resp);  
    } else {
      req.getRequestDispatcher("menu.jsp").forward(req, resp);
    }
  }

}

