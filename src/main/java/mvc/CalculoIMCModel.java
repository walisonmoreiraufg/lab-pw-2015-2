package mvc;

public class CalculoIMCModel {
  private Double peso;
  private Double altura;
  private Double imc;
  private String resultado;

  public Double getPeso() {
    return peso;
  }

  public void setPeso(Double peso) {
    this.peso = peso;
  }

  public Double getAltura() {
    return altura;
  }

  public void setAltura(Double altura) {
    this.altura = altura;
  }

  public Double getImc() {
    return imc;
  }

  public void setImc(Double imc) {
    this.imc = imc;
  }

  public String getResultado() {
    return resultado;
  }

  public void setResultado(String resultado) {
    this.resultado = resultado;
  }

  public void calcularImc() {
    imc = peso / (altura * altura);
  }

  public void calcularResultado() {
    if (imc <= 17) {
      resultado = "Magro";
    } else if (imc > 17 && imc <= 25) {
      resultado = "Normal";
    } else {
      resultado = "Acima do peso";
    }
  }

}
