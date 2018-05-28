package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Pais;
import modelo.Teste;

public class TesteDAO {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aulaJpaPU");
        EntityManager em = emf.createEntityManager();
        
        Teste t = new Teste();
        
        t.setNome("Marcos");
        
        em.getTransaction().begin();        
        em.persist(t);
        em.getTransaction().commit();
        
        System.out.println("Ok, Teste inserido!");
        
        
        Pais p = new Pais();
        
        p.setNome("Uruguai");
        p.setIso("URU");
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        
        
        
        

    }

}
