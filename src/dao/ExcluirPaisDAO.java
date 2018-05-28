package dao;

import javax.imageio.spi.ServiceRegistry;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.security.auth.login.Configuration;
import jpa.EntityManagerUtil;
import modelo.Pais;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ExcluirPaisDAO {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEM();
        
        Pais p = em.find(Pais.class, 2);

        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();

        EntityManagerUtil.closeFactory_EM();
        
        System.out.println("Pais: " + p.getNome());
    }

}
