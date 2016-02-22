package jpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.JpaUtil;

public class AlunoDao {

  public void gravar(Aluno aluno) {
    EntityManager em = null;
    EntityManagerFactory emf = null;
    try {
      //Obter uma fábrica de conexões com o banco de dados.
      emf = Persistence.createEntityManagerFactory("alunos-persistence-unit");

      //Obter conexão com o banco de dados.
      em = emf.createEntityManager();

      em.getTransaction().begin();

      em.merge(aluno);

      em.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
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
    List<Aluno> result = new ArrayList<Aluno>();
    try {
      String jpql = "from Aluno where ativo = 'sim' and mae.nome = 'Maria'";
      result = JpaUtil.getEntityManager().createQuery(jpql, Aluno.class).getResultList();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JpaUtil.closeEntityManager();
    }
    return result;
  }
}
