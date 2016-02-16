package jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aluno {
  @Id
  private String matricula;
  public String getMatricula() {return matricula;}
  public void setMatricula(String matricula) {this.matricula = matricula;}
  
  private String nome;
  public String getNome() {return nome;}
  public void setNome(String nome) {this.nome = nome;}
  
  private String fone;
  public String getFone() {return fone;}
  public void setFone(String fone) {this.fone = fone;}
  
  private String cpf;
  public String getCpf() {return cpf;}
  public void setCpf(String cpf) {this.cpf = cpf;}
}
