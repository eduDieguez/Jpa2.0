package dao;

import javax.imageio.spi.ServiceRegistry;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.security.auth.login.Configuration;
import modelo.Pais;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ExcluirPaisDAO {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aulaJpaPU");
        EntityManager em = emf.createEntityManager();

        Pais p = em.find(Pais.class, 4);
        
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        System.out.println("Pais: " + p.getNome());
        
        

    }

}
