package jpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pessoa {

  @Id
  private String cpf;
  public String getCpf() {return cpf;}
  public void setCpf(String cpf) {this.cpf = cpf;}

  private String nome;
  public String getNome() {return nome;}
  public void setNome(String nome) {this.nome = nome;}

}
