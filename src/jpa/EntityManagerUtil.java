package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static EntityManager getEM() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("aulaJpaPU");
        }
        if (em == null) {
            em = factory.createEntityManager();
        }
        return em;
    }

    public static EntityManager closeFactory_EM() {
        if (em != null) {
            em.close();
        }
        if (factory != null) {
            factory.close();
        }

        return em;
    }
}
