<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Testes JSP</title>
</head>
<body>
  <!-- Aqui é HTML. -->
  <h1>Testes JSP</h1>
  <!-- Começo do Scriptlet. -->
  <%
    //Aqui é Java.
    out.print("Aqui é Java");
  %>
  <!-- Fim do Scriptlet. -->
  <hr>
  Agora é: <%out.print(new java.util.Date());%>
  <hr>
  <form>
    Nome: <input type="text" name="nome">
    <br>
    Apelido: <input type="text" name="apelido">
    <br>
    <input type="submit">
  </form>
  Apelido Minúsculo: <%
  
  String apelido = request.getParameter("apelido");
  apelido = apelido == null ? "" : apelido;
  out.print(apelido.toLowerCase());
  %>
  <br>
  Nome Maiúsculo:
  <h2>
  <%
  //Obtém o parâmetro.
  String nome = request.getParameter("nome");
  
  nome = nome == null ? "" : nome;
  out.print(nome.toUpperCase());
  %>
  </h2>
</body>
</html>

