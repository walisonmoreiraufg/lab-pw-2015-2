<!doctype html>
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
  //Obtém o parâmetro.
  String apelido = request.getParameter("apelido");
  //Se o parâmetro não for passado, atribui vazio.
  apelido = apelido == null ? "" : apelido;
  
  out.print(apelido.toLowerCase());
  %>
  <br>
  Nome Maiúsculo:
  <%
  //Obtém o parâmetro.
  String nome = request.getParameter("nome");
  //Se o parâmetro não for passado, atribui vazio.
  nome = nome == null ? "" : nome;
  out.print(nome.toUpperCase());
  %>
</body>
</html>

