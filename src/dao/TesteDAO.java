package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.EntityManagerUtil;
import modelo.Pais;
import modelo.Teste;

public class TesteDAO {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEM();

        Teste t = new Teste();

        t.setNome("Mário Covas");

        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();

        System.out.println("Ok, Teste inserido!");

        Pais p = new Pais();

        p.setNome("Paraguai");
        p.setIso("PAR");

        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();

        EntityManagerUtil.closeFactory_EM();

    }

}
