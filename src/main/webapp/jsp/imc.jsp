<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Cálculo de IMC</title>

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
            <h3 class="panel-title">Cálculo de IMC</h3>
          </div>
          <div class="panel-body">
            <form role="form">
              <fieldset>
                <div class="form-group">
                  <input class="form-control" placeholder="Peso" name="peso"
                    type="text" value="${param.peso}">
                </div>
                <div class="form-group">
                  <input class="form-control" placeholder="Altura" name="altura"
                    type="text" value="${param.altura}">
                </div>
                <input type="submit" class="btn btn-sm btn-success" value="Calcular">
              </fieldset>
            </form>
            <br>

            <%!
            float calcular(float altura, float peso) {
              return peso / (altura * altura);
            }
            %>

            <%
            String paramPeso = request.getParameter("peso");
            paramPeso = paramPeso == null ? "0" : paramPeso;
            float peso = Float.parseFloat(paramPeso);

            String paramAltura = request.getParameter("altura");
            paramAltura = paramAltura == null ? "0" : paramAltura;
            float altura = Float.parseFloat(paramAltura);
            
            if (peso == 0 || altura == 0) {
%>
<!-- Aqui posso colocar HTML. -->
<div class="alert alert-danger" role="alert">Coloque algum valor nos campos Peso e Altura.</div>
<%
            } else {
              float imc = calcular(altura, peso);
              String resultado;
              if (imc <= 17) {
                resultado = "Magro";
              } else if (imc > 17 && imc <= 25) {
                resultado = "Normal";
              } else {
                resultado = "Acima do peso";
              }
              %>
<!-- Aqui posso colocar HTML. -->
<div class="alert alert-success" role="alert">
IMC: <%out.print(imc);%>
<br>
Resultado: <%out.print(resultado);%>
</div>
              <%
            }
            %>
            <br>
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