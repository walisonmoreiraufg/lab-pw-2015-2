package jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
  
  private String ativo;
  public String getAtivo() {return ativo;}
  public void setAtivo(String ativo) {this.ativo = ativo;}

  @ManyToOne(cascade=CascadeType.MERGE)
  private Pessoa mae;
  public Pessoa getMae() {return mae;}
  public void setMae(Pessoa mae) {this.mae = mae;}

  @ManyToOne(cascade=CascadeType.MERGE)
  private Pessoa pai;
  public Pessoa getPai() {return pai;}
  public void setPai(Pessoa pai) {this.pai = pai;}
}
