<!doctype html>
<%@page import="bancodados.cadastroaluno.Aluno"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cadastro de Aluno</title>

<!-- Bootstrap -->
<link
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
  rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
  <div class="container" style="margin-top: 30px">
    <div class="col-md-12">
      <div class="modal-dialog" style="margin-bottom: 0">
        <div class="modal-content">
          <div class="panel-heading">
            <h3 class="panel-title">Cadastro de Aluno</h3>
          </div>
          <div class="panel-body">
            <form role="form">
              <fieldset>
                <div class="form-group">
                  <input class="form-control" placeholder="Matrícula" name="matricula"
                    type="text" value="${param.matricula}">
                </div>
                <div class="form-group">
                  <input class="form-control" placeholder="Nome" name="nome"
                    type="text" value="${param.nome}">
                </div>
                <div class="form-group">
                  <input class="form-control" placeholder="Fone" name="fone"
                    type="text" value="${param.fone}">
                </div>
                <div class="form-group">
                  <input class="form-control" placeholder="CPF" name="cpf"
                    type="text" value="${param.cpf}">
                </div>
                <input type="submit" class="btn btn-sm btn-success" value="Incluir">
              </fieldset>
            </form>
            <br>
            <%
            //Obtendo a variável definida no servlet.
            bancodados.cadastroaluno.Aluno aluno = (bancodados.cadastroaluno.Aluno) request.getAttribute("aluno");
            //Se parâmetros inválidos, ...
            if (aluno.getMatricula() == null || aluno.getMatricula().trim().equals("")) {
%>
<!-- Aqui posso colocar HTML. -->
<div class="alert alert-danger" role="alert">Informe a Matrícula.</div>
<%
            } else {
              %>
<!-- Aqui posso colocar HTML. -->
<div class="alert alert-success" role="alert">
Matrícula: <%=aluno.getMatricula()%>
</div>
              <%
            }
            %>
<table class="table">
  <thead>
    <tr>
      <th>Matrícula</th>
      <th>Nome</th>
      <th>Fone</th>
      <th>CPF</th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
<%
List<Aluno> alunos = (List<Aluno>) request.getAttribute("alunos");
if (alunos != null && !alunos.isEmpty()) {
  for (Aluno a:alunos) {
%>
    <tr>
      <th><%=a.getMatricula()%></th>
      <td><%=a.getNome()%></td>
      <td><%=a.getFone()%></td>
      <td><%=a.getCpf()%></td>
      <td><a href="#">Alterar</a></td>
      <td><a href="#">Excluir</a></td>
    </tr>
<%
  }
}
%>
  </tbody>

</table>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>