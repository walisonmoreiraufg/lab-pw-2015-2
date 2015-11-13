package mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/imc")
public class CalculoIMCControle extends HttpServlet {

  protected void service(
      HttpServletRequest req,
      HttpServletResponse resp)
      throws ServletException, IOException {

    String paramPeso = req.getParameter("peso");
    Double peso = paramPeso == null ? 0.0 : Double.parseDouble(paramPeso);
    
    String paramAltura = req.getParameter("altura");
    Double altura = paramAltura == null ? 0.0 : Double.parseDouble(paramAltura);

    CalculoIMCModel cImc = new CalculoIMCModel();
    cImc.setPeso(peso);
    cImc.setAltura(altura);
    cImc.calcularImc();
    cImc.calcularResultado();
    
    req.setAttribute("imc", cImc); //Passando um objeto para o JSP.
    
    //Chamar o JSP apenas para mostrar o resultado.
    req.getRequestDispatcher("mvc/imc.jsp").forward(req, resp);
  }

}
