package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlunoDao {

  public void incluir(Aluno aluno) {
    EntityManager em = null;
    EntityManagerFactory emf = null;
    try {
      //Obter uma fábrica de conexões com o banco de dados.
      emf = Persistence.createEntityManagerFactory("alunos-persistence-unit");

      //Obter conexão com o banco de dados.
      em = emf.createEntityManager();

      em.getTransaction().begin();

      em.persist(aluno);

      em.getTransaction().commit();
    } catch (Exception e) {
      System.err.println(e.getMessage());
      if (em != null) {
        em.getTransaction().rollback();
      }
    } finally {
      if (em != null) {
        em.close();
      }
      if (emf != null) {
        emf.close();
      }
    }
  }

  public List<Aluno> listar() {
    return new ArrayList<Aluno>();
  }
}
