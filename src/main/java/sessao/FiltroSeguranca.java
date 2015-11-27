package sessao;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/sessao/*")
public class FiltroSeguranca implements Filter {

  public void init(FilterConfig filterConfig) throws ServletException {
  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    if (req.getRequestURI().endsWith("/sessao/login")) {
      chain.doFilter(request, response); //Continua com a requisição.
    } else {
      //Referência para a sessão.
      HttpSession sessao = req.getSession();

      //Obtém referência para o atributo "usuarioLogado".
      Boolean usuarioLogado = (Boolean) sessao.getAttribute("usuarioLogado");
      
      if (usuarioLogado == null || usuarioLogado == false) {
        res.sendRedirect("login");  
      } else {
        chain.doFilter(request, response); //Continua com a requisição.
      }
      
    }
  }

  public void destroy() {
  }

}
